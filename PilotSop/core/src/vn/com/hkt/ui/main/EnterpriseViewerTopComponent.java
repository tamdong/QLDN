/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.ui.main;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.cookies.ViewCookie;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.viewer.api.FilterCookie;
import vn.com.hkt.pilot.viewer.api.IEnterpriseExtViewer;
import vn.com.hkt.pilot.viewer.api.IEnterpriseViewer;
import vn.com.hkt.pilot.viewer.api.RemoveCookie;
import vn.com.hkt.pilot.viewer.api.ResetCookie;
import vn.com.hkt.pilot.viewer.api.ResetCookieList;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.ui.main//EnterpriseViewer//EN",
autostore = false)
@TopComponent.Description(preferredID = "EnterpriseViewerTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.ui.main.EnterpriseViewerTopComponent")
@ActionReference(path = "Menu/Thị Trường" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_EnterpriseViewerAction",
preferredID = "EnterpriseViewerTopComponent")
public final class EnterpriseViewerTopComponent extends TopComponent {

    private IEnterpriseViewer enterpriseViewer;
    private Collection<? extends IEnterpriseExtViewer> enterpriseExtViewer;
    private DefaultComboBoxModel model;

    public EnterpriseViewerTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(EnterpriseViewerTopComponent.class, "CTL_EnterpriseViewerTopComponent"));
        setToolTipText(NbBundle.getMessage(EnterpriseViewerTopComponent.class, "HINT_EnterpriseViewerTopComponent"));

        load();
        if (model.getSize() > 0) {
            cboSelectView.setEnabled(true);
            Object selected = cboSelectView.getItemAt(0);
            IEnterpriseExtViewer middle = (IEnterpriseExtViewer) selected;
            JPanel p = middle.getEnterpriseExtViewer();
            panelForm.removeAll();
            panelForm.add(p);
            cboSelectView.setSelectedIndex(0);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topComponent1 = new org.openide.windows.TopComponent();
        panelForm = new javax.swing.JPanel();
        panleButton = new javax.swing.JPanel();
        buttonEdit = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboTimkiem = new javax.swing.JComboBox();
        txtTimKiem = new javax.swing.JTextField();
        cboSelectView = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        panleButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(buttonEdit, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.buttonEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSave, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.buttonSave.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonExit, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.buttonExit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonHelp, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.buttonHelp.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonDelete, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.buttonDelete.text")); // NOI18N
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panleButtonLayout = new javax.swing.GroupLayout(panleButton);
        panleButton.setLayout(panleButtonLayout);
        panleButtonLayout.setHorizontalGroup(
            panleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panleButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );
        panleButtonLayout.setVerticalGroup(
            panleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panleButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEdit)
                    .addComponent(buttonSave)
                    .addComponent(buttonDelete)
                    .addComponent(buttonExit)
                    .addComponent(buttonHelp))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.jLabel1.text")); // NOI18N

        cboTimkiem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tên", "ID", " " }));

        txtTimKiem.setText(org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.txtTimKiem.text")); // NOI18N
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        cboSelectView.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cboSelectView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectViewActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(EnterpriseViewerTopComponent.class, "EnterpriseViewerTopComponent.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cboTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cboSelectView, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSelectView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout topComponent1Layout = new javax.swing.GroupLayout(topComponent1);
        topComponent1.setLayout(topComponent1Layout);
        topComponent1Layout.setHorizontalGroup(
            topComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topComponent1Layout.setVerticalGroup(
            topComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topComponent1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        resetList();
        remove();
        load();
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        if (txtTimKiem.getText().trim().length() != 0) {
            Collection<? extends FilterCookie> allSave = Lookup.getDefault().lookupAll(FilterCookie.class);
            for (FilterCookie filterCookie : allSave) {
                String strTim = txtTimKiem.getText().trim();
                if (cboTimkiem.getSelectedIndex() == 0) {
                    try {
                        filterCookie.filterName(strTim);
                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                } else if (cboTimkiem.getSelectedIndex() == 1) {
                    try {
                        filterCookie.filterID(strTim);
                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
            }
        } else {
            load();
        }

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void cboSelectViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectViewActionPerformed
        // TODO add your handling code here:
        panelForm.setLayout(new GridLayout());
        Object selected = cboSelectView.getSelectedItem();
        int row = cboSelectView.getSelectedIndex();
        if (selected instanceof IEnterpriseExtViewer) {
            IEnterpriseExtViewer p = (IEnterpriseExtViewer) selected;
            //JPanel p1 = enterpriseViewer.getEnterpriseViewer();
            JPanel p2 = p.getEnterpriseExtViewer();
            panelForm.removeAll();
            //panelForm.add(p1);
            panelForm.add(p2);
            this.close();
            this.open();
            
            cboSelectView.setSelectedIndex(row);
            this.requestActive();
        }


    }//GEN-LAST:event_cboSelectViewActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        if (txtTimKiem.getText().trim().equals("Tìm theo tên hoặc mã")) {
            txtTimKiem.setText("");
        }
    }//GEN-LAST:event_txtTimKiemMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox cboSelectView;
    private javax.swing.JComboBox cboTimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPanel panleButton;
    private org.openide.windows.TopComponent topComponent1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        load();
        if (model.getSize() > 0) {
            cboSelectView.setEnabled(true);
        } else {
            cboSelectView.setEnabled(false);
        }
        buttonEdit.setEnabled(false);
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
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

    public void load() {
        enterpriseViewer = Lookup.getDefault().lookup(IEnterpriseViewer.class);
        enterpriseExtViewer = Lookup.getDefault().lookupAll(IEnterpriseExtViewer.class);
        this.setLayout(new GridLayout());
        loadToCombo();
        cboSelectView.setModel(model);
        if ((enterpriseExtViewer.isEmpty()) && (enterpriseViewer != null)) {
            panelForm.setLayout(new GridLayout());
            JPanel p1 = enterpriseViewer.getEnterpriseViewer();
            panelForm.removeAll();
            panelForm.add(p1);
            cboSelectView.setEnabled(false);
        }
        Collection<? extends ViewCookie> allView = Lookup.getDefault().lookupAll(ViewCookie.class);
        for (ViewCookie viewCookie : allView) {
            viewCookie.view();
        }

    }

    public void remove() {
        Collection<? extends RemoveCookie> allSave = Lookup.getDefault().lookupAll(RemoveCookie.class);
        for (RemoveCookie removeCookie : allSave) {
            try {
                removeCookie.remove();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
         Collection<? extends ResetCookieList> allSave1 = Lookup.getDefault().lookupAll(ResetCookieList.class);
        for (ResetCookieList editCookie : allSave1) {
            try {
                editCookie.resetCookie();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    public void resetList() {
        Collection<? extends ResetCookieList> allSave1 = Lookup.getDefault().lookupAll(ResetCookieList.class);
        for (ResetCookieList editCookie : allSave1) {
            try {
                editCookie.resetCookie();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    protected void loadToCombo() {
        model = new DefaultComboBoxModel();
        if (!enterpriseExtViewer.isEmpty()) {
            Iterator it = enterpriseExtViewer.iterator();
            while (it.hasNext()) {
                model.addElement(it.next());
            }
        }
    }
}
