import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    
    DB_MAN DBM = new DB_MAN();
    String strSQL = "Select * From CASHBOOK";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    
//추가 부분 
//======================================================== 
    private String userName; // 이름을 저장할 멤버 변수 추가

// 새로운 생성자 추가 (로그인 화면에서 이름을 받을 때 사용)
public MainFrame(String name) {
    this.userName = name; // 전달받은 이름을 저장
    initComponents(); 

    // 이름을 화면에 표시하는 메소드 호출
    displayUserName(); 
}
//======================================================== 

public MainFrame() {
        initComponents(); 
        try {
            DBM.dbOpen();
            getDBData(strSQL);
            DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException" + e.getMessage());
        }
    }

    //추가 부분 
   //======================================================== 
    private void displayUserName() {
    if (userName != null && !userName.isEmpty()) {
       lbl_user_name.setText(this.userName); 
    } else {
       lbl_user_name.setText("게스트"); 
    }
}
    //======================================================== 
    public final void getDBData(String strQuery) {
        DefaultTableModel model = (DefaultTableModel) tblAccount.getModel();
        model.setRowCount(0); // 기존 테이블 내용 비우기

        // [1] 합계를 계산하기 위한 변수 초기화 (여기서부터 시작)
        long totalIncome = 0;  // 총 수입
        long totalExpense = 0; // 총 지출

        try {
            DBM.dbOpen();
            DBM.DB_rs = DBM.DB_stmt.executeQuery(strQuery);

            while (DBM.DB_rs.next()) {
                String no = DBM.DB_rs.getString("NO");
                String day = DBM.DB_rs.getString("DAY");
                String type = DBM.DB_rs.getString("TYPE");
                String category = DBM.DB_rs.getString("CATEGORY");
                String memo = DBM.DB_rs.getString("MEMO");
                String strAmount = DBM.DB_rs.getString("AMOUNT"); // DB에 있는 금액 문자열

                // [2] 금액 더하기 로직 (DB에서 가져온 값을 숫자로 바꿔서 더함)
                try {
                    // 혹시 DB에 콤마(,)가 섞여있을 수 있으니 제거하고 숫자로 변환
                    long val = Long.parseLong(strAmount.replace(",", ""));

                    if ("수입".equals(type)) { // 구분이 '수입'이면
                        totalIncome += val;
                    } else { // 구분이 '지출'이면
                        totalExpense += val;
                    }
                } catch (Exception e) {
                    // 숫자가 아닌 값이 들어있으면 무시 (에러 방지)
                }

                // [3] 테이블에 보여줄 때는 콤마(,) 찍기
                String formattedAmount = strAmount;
                try {
                    long amountVal = Long.parseLong(strAmount.replace(",", ""));
                    DecimalFormat df = new DecimalFormat("#,###");
                    formattedAmount = df.format(amountVal);
                } catch (Exception e) {}

                // 테이블에 한 줄 추가
                model.addRow(new Object[]{no, day, type, category, memo, formattedAmount});
            }

            // [4] 반복문이 끝난 후, 계산된 합계를 화면 라벨에 표시 (setText)
            DecimalFormat df = new DecimalFormat("#,###");

            lblTotalIncome.setText("총 수입: " + df.format(totalIncome) + "원");
            lblTotalExpense.setText("총 지출: " + df.format(totalExpense) + "원");

            // 잔액 계산 (수입 - 지출)
            long balance = totalIncome - totalExpense;
            lblBalance.setText("잔액: " + df.format(balance) + "원");

            DBM.dbClose();
        } catch (Exception e) {
            System.out.println("조회 에러: " + e.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        centerPanel = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        northPanel = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblTotalIncome = new javax.swing.JLabel();
        lblTotalExpense = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblProgramName = new javax.swing.JLabel();
        southPanel = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        rbIncome = new javax.swing.JRadioButton();
        rbExpense = new javax.swing.JRadioButton();
        cmbCategory = new javax.swing.JComboBox<>();
        lblCategory = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtMemo = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        lblMemo = new javax.swing.JLabel();
        lbl_user_name = new javax.swing.JLabel();
        lblwelcome = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Date", "Type", "Category", "Memo", "Amount"
            }
        ));
        tblAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountMouseClicked(evt);
            }
        });
        centerPanel.setViewportView(tblAccount);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblTotalIncome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalIncome.setText("TotalIncome");

        lblTotalExpense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalExpense.setText("TotalExpense");

        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBalance.setText("Balance");

        javax.swing.GroupLayout northPanelLayout = new javax.swing.GroupLayout(northPanel);
        northPanel.setLayout(northPanelLayout);
        northPanelLayout.setHorizontalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        northPanelLayout.setVerticalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblProgramName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgramName.setText("Program Name");

        buttonGroup1.add(rbIncome);
        rbIncome.setText("Income");

        buttonGroup1.add(rbExpense);
        rbExpense.setText("Expense");

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "식비", "카페·간식", "유흥", "쇼핑", "취미·여가", "의료·보험", "급여", "저축", "이체", "교통", "기타", " ", " " }));

        lblCategory.setText("Category :");

        lblAmount.setText("Amount :");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblDate.setText("Date");

        lblMemo.setText("Memo");

        javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
        southPanel.setLayout(southPanelLayout);
        southPanelLayout.setHorizontalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(southPanelLayout.createSequentialGroup()
                                .addComponent(lblMemo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(southPanelLayout.createSequentialGroup()
                                .addComponent(txtMemo)
                                .addGap(18, 18, 18)
                                .addComponent(rbIncome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbExpense))))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(lblCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        southPanelLayout.setVerticalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(lblMemo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMemo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(rbIncome)
                        .addComponent(rbExpense))
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategory)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmount))
                .addGap(18, 18, 18)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        lbl_user_name.setText("user_name");

        lblwelcome.setText("님 환영합니다 !");

        btn_logout.setText("logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(centerPanel)
                    .addComponent(northPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(southPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_logout)
                .addGap(72, 72, 72)
                .addComponent(lblProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_user_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblwelcome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_user_name)
                            .addComponent(lblwelcome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProgramName)
                            .addComponent(btn_logout))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(northPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(southPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountMouseClicked
        // TODO add your handling code here:
        
        int row = tblAccount.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblAccount.getModel();

        // 1. 날짜
        txtDate.setText(model.getValueAt(row, 1).toString());

        // 2. 수입/지출 구분
        String type = model.getValueAt(row, 2).toString();
        if ("수입".equals(type)) {
            rbIncome.setSelected(true);
        } else {
            rbExpense.setSelected(true);
        }

        // 3. 카테고리 (콤보박스 선택)
        cmbCategory.setSelectedItem(model.getValueAt(row, 3).toString());

        // 4. 메모
        txtMemo.setText(model.getValueAt(row, 4).toString());

        // 5. 금액 (콤마를 제거하고 입력창에 넣어야 수정할 때 오류 안 남)
        String amount = model.getValueAt(row, 5).toString().replace(",", "");
        txtAmount.setText(amount);
    }//GEN-LAST:event_tblAccountMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        
            String searchMonth = txtSearch.getText().trim();

            if (searchMonth.isEmpty()) {
                // 입력 없으면 전체 조회
                strSQL = "SELECT * FROM CASHBOOK ORDER BY DAY DESC";
            } else {
                // "11"을 입력하면 "011"이 안되게 처리 (예: 5월 -> 05월)
                if (searchMonth.length() == 1) {
                    searchMonth = "0" + searchMonth;
                }
                // 문자열 날짜 검색 (YYYY-MM-DD 형식 중 MM을 검색)
                strSQL = "SELECT * FROM CASHBOOK WHERE DAY LIKE '%-" + searchMonth + "-%' ORDER BY DAY DESC";
            }
            getDBData(strSQL);   
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String day = txtDate.getText();
        String type = rbIncome.isSelected() ? "수입" : "지출";
        String category = cmbCategory.getSelectedItem().toString();
        String memo = txtMemo.getText();
        String amount = txtAmount.getText(); // 콤마 없는 숫자

        // NO는 시퀀스로, 나머지는 문자열로 입력 (따옴표 주의)
        strSQL = "INSERT INTO CASHBOOK (NO, DAY, TYPE, CATEGORY, MEMO, AMOUNT) VALUES (";
        strSQL += "TO_CHAR(SEQ_ACCOUNT_NO.NEXTVAL), "; 
        strSQL += "'" + day + "', ";
        strSQL += "'" + type + "', ";
        strSQL += "'" + category + "', ";
        strSQL += "'" + memo + "', ";
        strSQL += "'" + amount + "')"; // AMOUNT도 VARCHAR2이므로 따옴표 필수

        try {
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL); // INSERT 실행
            DBM.dbClose();
            
            getDBData("SELECT * FROM CASHBOOK ORDER BY DAY DESC"); // 목록 갱신
            btnResetActionPerformed(null); // 입력창 초기화
        } catch (Exception e) {
            System.out.println("입력 에러: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "입력에 실패했습니다. 값을 확인해주세요.");
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        int row = tblAccount.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "수정할 목록을 선택해주세요.");
            return;
        }

        // 선택된 행의 고유 번호(NO) 가져오기
        String no = tblAccount.getValueAt(row, 0).toString();

        String day = txtDate.getText();
        String type = rbIncome.isSelected() ? "수입" : "지출";
        String category = cmbCategory.getSelectedItem().toString();
        String memo = txtMemo.getText();
        String amount = txtAmount.getText();

        strSQL = "UPDATE CASHBOOK SET ";
        strSQL += "DAY = '" + day + "', ";
        strSQL += "TYPE = '" + type + "', ";
        strSQL += "CATEGORY = '" + category + "', ";
        strSQL += "MEMO = '" + memo + "', ";
        strSQL += "AMOUNT = '" + amount + "' ";
        strSQL += "WHERE NO = '" + no + "'"; // NO도 문자열 처리

        try {
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            DBM.dbClose();
            getDBData("SELECT * FROM CASHBOOK ORDER BY DAY DESC");
            btnResetActionPerformed(null);
        } catch (Exception e) {
            System.out.println("수정 에러: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tblAccount.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 목록을 선택해주세요.");
            return;
        }

        String no = tblAccount.getValueAt(row, 0).toString();

        strSQL = "DELETE FROM CASHBOOK WHERE NO = '" + no + "'";

        try {
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            DBM.dbClose();
            getDBData("SELECT * FROM CASHBOOK ORDER BY DAY DESC");
            btnResetActionPerformed(null);
        } catch (Exception e) {
            System.out.println("삭제 에러: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtDate.setText("");
        txtAmount.setText("");
        txtMemo.setText("");
        cmbCategory.setSelectedIndex(0);
        rbExpense.setSelected(true); // 기본값 지출로
        tblAccount.clearSelection(); // 테이블 선택 해제
    }//GEN-LAST:event_btnResetActionPerformed
    //로그아웃 화면
    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
     // 1. 로그인 프레임(sign_login_mainFrame) 객체 생성 및 표시
    sign_login_mainFrame loginFrame = new sign_login_mainFrame();
    loginFrame.setVisible(true);
    
    // 2. 현재 메인 창 닫기
    this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_logout;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane centerPanel;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMemo;
    private javax.swing.JLabel lblProgramName;
    private javax.swing.JLabel lblTotalExpense;
    private javax.swing.JLabel lblTotalIncome;
    private javax.swing.JLabel lbl_user_name;
    private javax.swing.JLabel lblwelcome;
    private javax.swing.JPanel northPanel;
    private javax.swing.JRadioButton rbExpense;
    private javax.swing.JRadioButton rbIncome;
    private javax.swing.JPanel southPanel;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtMemo;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
