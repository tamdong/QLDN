/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.erm.department.ui;

import java.io.IOException;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.basic.api.IDepartmentBN;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.WindowManager;
import vn.com.hkt.bom.operation.ui.OperationTopComponent;
import vn.com.hkt.bom.product.ui.ProductTopComponent;
import vn.com.hkt.erm.enterprise.ui.EnterpriseTopComponent;
import vn.com.hkt.hrm.person.ui.PersonTopComponent;
import vn.com.hkt.pilot.viewer.api.Observable;
import vn.com.hkt.pilot.viewer.api.Observer;
import vn.com.hkt.pilot.viewer.api.ResetCookieList;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.erm.department.ui//Department//EN",
autostore = false)
@TopComponent.Description(preferredID = "DepartmentTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.erm.department.ui.DepartmentTopComponent")
@ActionReference(path = "Menu/Nhập Số Liệu" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_DepartmentAction",
preferredID = "DepartmentTopComponent")
@ServiceProvider(service = ResetCookieList.class)
public final class DepartmentTopComponent extends TopComponent implements ActionListener, ResetCookieList, Observer, Observable {

    private DepartmentPanel departmentPanel = new DepartmentPanel();
    private IDepartmentBN departmentBN;
    private Vector obs;
    private boolean change = false;

    public Vector getObs() {
        return obs;
    }

    public JPanel getPanelForm() {
        return panelForm;
    }

    public DepartmentTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(DepartmentTopComponent.class, "CTL_DepartmentTopComponent"));
        setToolTipText(NbBundle.getMessage(DepartmentTopComponent.class, "HINT_DepartmentTopComponent"));

        panelForm.setLayout(new GridLayout());
        panelForm.add(departmentPanel);

        buttonEdit.setEnabled(false);

        buttonSaveDS.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonHelp.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonSave.addActionListener(this);

        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        obs = new Vector();
    }

    public DepartmentPanel getDepartmentPanel() {
        return departmentPanel;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForm = new javax.swing.JPanel();
        panelButton = new javax.swing.JPanel();
        buttonReset = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonSaveDS = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        panelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(buttonReset, org.openide.util.NbBundle.getMessage(DepartmentTopComponent.class, "DepartmentTopComponent.buttonReset.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonEdit, org.openide.util.NbBundle.getMessage(DepartmentTopComponent.class, "DepartmentTopComponent.buttonEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSave, org.openide.util.NbBundle.getMessage(DepartmentTopComponent.class, "DepartmentTopComponent.buttonSave.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonExit, org.openide.util.NbBundle.getMessage(DepartmentTopComponent.class, "DepartmentTopComponent.buttonExit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSaveDS, org.openide.util.NbBundle.getMessage(DepartmentTopComponent.class, "DepartmentTopComponent.buttonSaveDS.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonHelp, org.openide.util.NbBundle.getMessage(DepartmentTopComponent.class, "DepartmentTopComponent.buttonHelp.text")); // NOI18N

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveDS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset)
                    .addComponent(buttonEdit)
                    .addComponent(buttonSave)
                    .addComponent(buttonSaveDS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonExit)
                    .addComponent(buttonHelp))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonSaveDS;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelForm;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        if (obs.isEmpty()) {
            addObserver();
        }
    }

    @Override
    public void componentClosed() {
        reset();
        obs.removeAllElements();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        // bắt sự kiện cho nút lưu và ra danh sách
        if (button == buttonSaveDS) {
            update();

        }

        // bắt sự kiện cho nút làm mới form nhập
        if (button == buttonReset) {
            reset();
            buttonEdit.setEnabled(false);
            departmentPanel.getTableD().setEnabled(true);
        }

        // bắt sự kiện cho nút thoát
        if (button == buttonExit) {
            this.close();
        }
        if (button == buttonSave) {
            save();

        }
        if (button == buttonEdit) {
            buttonEdit.setEnabled(false);
            departmentPanel.getTableD().setEnabled(true);
        }
    }

    // reset lại table mỗi khi save hoặc muốn điền mới
    public void reset() {
        departmentPanel.getTableD().setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"Tên dự án", " "},
                    {"Mã dự án", " "},
                    {"Công ty", " "},
                    {"Trưởng dự án", " "},
                    {"Phân cấp", " "},
                    {"Phòng ban mẹ", " "},
                    {"Sản phẩm dịch vụ", " "}
                },
                new String[]{
                    "", ""
                }) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        departmentPanel.getTableD().getColumnModel().getColumn(1).setCellEditor(new DepartmentCell());
    }

    public void save() {

        String id = departmentPanel.getTableD().getValueAt(1, 1).toString().trim();
        String name = departmentPanel.getTableD().getValueAt(0, 1).toString().trim();
        String enter = departmentPanel.getTableD().getValueAt(2, 1).toString().trim();
        String person = departmentPanel.getTableD().getValueAt(3, 1).toString().trim();
        String phancap = departmentPanel.getTableD().getValueAt(4, 1).toString().trim();
        String duan_me = departmentPanel.getTableD().getValueAt(5, 1).toString().trim();
        String spdv = departmentPanel.getTableD().getValueAt(6, 1).toString().trim();
        Department bean = new Department(id, name, enter, person,phancap, duan_me, spdv);
        if (departmentPanel.getTableD().getValueAt(0, 1).toString().trim().length() != 0 && departmentPanel.getTableD().getValueAt(1, 1).toString().trim().length() != 0) {
            departmentBN.updateDepartment(bean);
            this.setChanged();
            this.notifyObservers(null);
            this.close();
            this.open();

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã hoặc tên");
        }


    }

    public void update() {

        String id = departmentPanel.getTableD().getValueAt(1, 1).toString().trim();
        String name = departmentPanel.getTableD().getValueAt(0, 1).toString().trim();
        String enter = departmentPanel.getTableD().getValueAt(2, 1).toString().trim();
        String person = departmentPanel.getTableD().getValueAt(3, 1).toString().trim();
        String duan_me = departmentPanel.getTableD().getValueAt(5, 1).toString().trim();
        String spdv = departmentPanel.getTableD().getValueAt(6, 1).toString().trim();
        String phancap = departmentPanel.getTableD().getValueAt(4, 1).toString().trim();
        Department bean = new Department(id, name, enter, person,phancap, duan_me, spdv);
        if (departmentPanel.getTableD().getValueAt(0, 1).toString().trim().length() != 0 && departmentPanel.getTableD().getValueAt(1, 1).toString().trim().length() != 0) {
            departmentBN.updateDepartment(bean);
            this.setChanged();
            this.notifyObservers(null);
            this.close();
            ListDepartmentTopComponent tc5 = (ListDepartmentTopComponent) WindowManager.getDefault().findTopComponent("ListDepartmentTopComponent");
            if (tc5 != null) {
                tc5.open();
                tc5.loadData();
                tc5.requestActive();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã hoặc tên");
        }

    }

    @Override
    public void resetCookie() throws IOException {
        DepartmentTopComponent tc2 = (DepartmentTopComponent) WindowManager.getDefault().findTopComponent("DepartmentTopComponent");
        if (tc2 != null) {
            tc2.reset();
        }
    }

    @Override
    public void updateObserver(Observable o, Object arg) {
        reset();
    }

    @Override
    public void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!change) {
                return;
            }
            arrLocal = obs.toArray();
            clearChanged();
        }
        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((Observer) arrLocal[i]).updateObserver(this, arg);
        }
    }

    @Override
    public void setChanged() {
        change = true;
    }

    @Override
    public void clearChanged() {
        change = false;
    }

    public void addObserver() {
        ProductTopComponent tc = (ProductTopComponent) WindowManager.getDefault().findTopComponent("ProductTopComponent");
        if (tc != null) {
            obs.addElement(tc);
        }
        OperationTopComponent tc1 = (OperationTopComponent) WindowManager.getDefault().findTopComponent("OperationTopComponent");
        if (tc1 != null) {
            obs.addElement(tc1);
        }

        PersonTopComponent tc3 = (PersonTopComponent) WindowManager.getDefault().findTopComponent("PersonTopComponent");
        if (tc3 != null) {
           obs.addElement(tc3);
        }
        EnterpriseTopComponent tc4 = (EnterpriseTopComponent) WindowManager.getDefault().findTopComponent("EnterpriseTopComponent");
        if (tc4 != null) {
           obs.addElement(tc4);
        }

    }
}
