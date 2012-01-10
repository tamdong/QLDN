/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.finance.spi;

import vn.com.hkt.finance.api.ICount;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IOperationBN;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.basic.api.IProductBN;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service = ICount.class)
public class CountSPI implements ICount {

    private IPersonBN personBN;
    private IEnterpriseBN enterpriseBN;
    private IProductBN productBN;
    private IOperationBN operationBN;
    private IDepartmentBN departmentBN;

    public CountSPI() {

        this.enterpriseBN = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.operationBN = Lookup.getDefault().lookup(IOperationBN.class);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
    }

    @Override
    public int countPerson(Enterprise enterprise, Department department) {
        int S = 0;
        List<Person> result = new ArrayList<Person>();
        List<Person> list = personBN.getAllPerson();
        if (!list.isEmpty()) {
            for (Person bean : list) {
                if ((bean.getEnterpriseID().equals(enterprise.getEnterpriseID()))
                        && (bean.getDepartmentName().equals(department.getDepartmentName()))) {
                    result.add(bean);
                }
            }
        }
        if (!result.isEmpty()) {
            S = result.size();
        }
        return S;
    }

    @Override
    public int countEnterprise() {
        int S = 0;
        List<Enterprise> list = enterpriseBN.getAllEnterprise();
        if (!list.isEmpty()) {
            S = list.size();
        }
        return S;
    }

    @Override
    public int countDepartmentByEnterprise(Enterprise enterprise) {
        int S = 0;
        List<Department> result = new ArrayList<Department>();
        List<Department> list = departmentBN.getAllDepartment();
        if (!list.isEmpty()) {
            for (Department bean : list) {
                if (bean.getEnterpriseID().equals(enterprise.getEnterpriseID())) {
                    result.add(bean);
                }
            }
        }
        if (!result.isEmpty()) {
            S = result.size();
        }
        return S;
    }

    @Override
    public int countProductByEnterprise(Enterprise enterprise) {
        int S = 0;
        List<Product> result = new ArrayList<Product>();
        List<Product> list = new ArrayList<Product>();
        list = productBN.getAllProduct();
        if (!list.isEmpty()) {
            for (Product bean : list) {
                if (bean.getEnterpriseID().equals(enterprise.getEnterpriseID())) {
                    result.add(bean);
                }
            }
        }

        if (!result.isEmpty()) {
            S = result.size();
        }

        return S;
    }

    @Override
    public int countOperation(Enterprise enter, Department depar, Person person, Product product) {
        int S = 0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.getAllOperation();
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getDepartmentID().equals(depar.getDepartmentID())) && (bean.getPersonID().equals(person.getPersonID()))
                        && (bean.getProductID().equals(product.getProductID()))) {
                    S++;
                }
            }
        }
        return S;
    }

    @Override
    public int countOperation(Enterprise enter, String date) {

        int S = 0;
        int i;
        List<Operation> list = operationBN.filterOperationByDate(date);
        if (!list.isEmpty()) {
            for (i = 0; i < list.size(); i++) {
                if (list.get(i).getEnterpriseID().equals(enter.getEnterpriseID())) {
                    S++;
                }
            }
        }
        return S;
    }

    @Override
    public int countOperation(Enterprise enter, String classification, String date) {
        int S = 0;
        int i;
        List<Operation> list = operationBN.filterOperationByDate(date);
        if (!list.isEmpty()) {
            for (i = 0; i < list.size(); i++) {
                if ((list.get(i).getEnterpriseID().equals(enter.getEnterpriseName()))
                        && (list.get(i).getClassification().equals(classification))) {
                    S++;
                }
            }
        }
        return S;
    }

    //////////////////// implements các phương thức đếm theo kiểu parent-child ///////////////////
    /**
     * Ham de quy tinh theo enterprise,
     * enterprise + department
     * enterprise + product
     * @param enterprise
     * @param department
     * @param product
     * @param S
     * @return 
     */
    protected int recursionOperationCount(Enterprise enterprise, Department department, Product product, int S) {
        
        if (department == null && product == null) {
            List<Enterprise> enterprises = new ArrayList<Enterprise>();
            enterprises = enterpriseBN.filterEnterpriseByChild(enterprise);
            if (enterprises.isEmpty()) {
                List<Operation> list = new ArrayList<Operation>();
                list = operationBN.getOperationByEnterprise(enterprise);
                S = list.size();
            } else {
                for (Enterprise e : enterprises) {
                    S += recursionOperationCount(e, null, null, S);
                }
            }
        } else if (department != null && product == null) {
            List<Department> departments = new ArrayList<Department>();
            departments = departmentBN.filterDepartmentByEnterprise(enterprise);
            if (departments.isEmpty()) {
                List<Operation> list = new ArrayList<Operation>();
                list = operationBN.filterOperationByDepartment(enterprise, department);
                S = list.size();
            } else {
                for (Department d : departments) {
                    S += recursionOperationCount(enterprise, d, null, S);
                }
            }
        } else if (department == null && product != null) {
            List<Product> products = new ArrayList<Product>();
            products = productBN.getByEnterprise(enterprise);
            if (products.isEmpty()) {
                List<Operation> list = new ArrayList<Operation>();
                list = operationBN.filterOperationByDepartment(enterprise, department);
                S = list.size();
            } else {
                for (Product p : products) {
                    S += recursionOperationCount(enterprise, null, p, S);
                }
            }
        }
        return S;
    }

    @Override
    public int countOperationByEnterpriseChild(Enterprise enterprise) {
        return recursionOperationCount(enterprise, null, null, 0);
    }

    @Override
    public int countOperationByDepartmentChild(Enterprise enterprise, Department department) {
        return recursionOperationCount(enterprise, department, null, 0);
    }

    @Override
    public int countOperationByProductChild(Enterprise enterprise, Product product) {
        return recursionOperationCount(enterprise, null, product, 0);
    }
    
    /**
     * De quy dem so luong person theo enterprise
     * theo enterprise + department
     * @param enterprise
     * @param department
     * @return 
     */
    protected int recursionPersonCount(Enterprise enterprise, Department department, int S){
        if(department==null){
            List<Enterprise> enterprises = new ArrayList<Enterprise>();
            enterprises = enterpriseBN.filterEnterpriseByChild(enterprise);
            if(enterprises.isEmpty()){
                List<Person> persons = personBN.filterPersonByEnterprise(enterprise);
                S = persons.size();
            }
            else{
                for(Enterprise bean : enterprises){
                    S += recursionPersonCount(enterprise, null, S);
                }
            }
        }
        if(department!=null){
            List<Department> departments = new ArrayList<Department>();
            departments = departmentBN.filterDepartmentByRootDepartment(enterprise,department);
            if(departments.isEmpty()){
                List<Person> persons = personBN.filterPersonByEnterprise(enterprise);
                S = persons.size();
            }
            else{
                for(Department bean : departments){
                    S += recursionPersonCount(enterprise, bean, S);
                }
            }
        }
        return S;       
    }
    
    @Override
    public int countPersonByDepartmentChild(Enterprise enterprise, Department department) {
        return  recursionPersonCount(enterprise, department, 0);
    }

    @Override
    public int countPersonByEnterprseChild(Enterprise enterprise) {
        return recursionPersonCount(enterprise, null, 0);
    }
    
    /**
     * Dem so Product thuoc Department co trong Operation
     * @param enterprise
     * @param department
     * @return 
     */
    @Override
    public int countProductByDepartmentChild(Enterprise enterprise, Department department) {
        int S = 0;
        List<Product> list = productBN.filterProductByDepartment(enterprise, department);
        if(!list.isEmpty()){
            for(Product bean : list){
                List<Operation> operations = operationBN.filterOperationByProduct(enterprise, department, bean);
                S += operations.size();
            }
        }
        return S;
    }

    /**
     * Ham de quy dem so department theo 
     * @param enterprise
     * @return 
     */
    
    @Override
    public int countDepartmentByEnterpriseChild(Enterprise enterprise) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int countProductByEnterpriseChild(Enterprise enterprise) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
