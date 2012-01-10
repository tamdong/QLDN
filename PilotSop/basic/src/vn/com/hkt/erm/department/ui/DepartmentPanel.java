/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DepartmentPanel.java
 *
 * Created on Nov 23, 2011, 3:53:19 PM
 */
package vn.com.hkt.erm.department.ui;

import vn.com.hkt.erm.department.ui.DepartmentCell;
import javax.swing.JTable;

/**
 *
 * @author longnt
 */
public class DepartmentPanel extends javax.swing.JPanel {

    /** Creates new form DepartmentPanel */
    public DepartmentPanel() {
        initComponents();
        
        tableD.getColumnModel().getColumn(1).setCellEditor(new DepartmentCell());
    }

    public JTable getTableD() {
        return tableD;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableD = new javax.swing.JTable();

        tableD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tên dự án", " "},
                {"Mã dự án", " "},
                {"Công ty", " "},
                {"Trưởng dự án", " "},
                {"Phân cấp", " "},
                {"Phòng ban mẹ", " "},
                {"Sản phẩm dịch vụ", " "},
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableD.setRowHeight(25);
        jScrollPane1.setViewportView(tableD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableD;
    // End of variables declaration//GEN-END:variables
}
