import javax.swing.JOptionPane;

public class sign_login_mainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(sign_login_mainFrame.class.getName());
     DB_MAN DBM =new DB_MAN();
    
     //!!!(참고사항) 여기에서는 MEMBERINFO 테이블을 사용함
     String strSQL = "";//쿼리를 저장할 변수 
     boolean id_duple_flag = false;//플래그 변수 -> 아이디 중복 확인을 했나 안했나 확인 
     private int captchaAnswer = 0; //캡차 정답을 담을 변수 
   
    public sign_login_mainFrame() {
        initComponents();
        generateCaptcha();//캡차 생성
    }

 // 두 수를 더하는 캡챠
private void generateCaptcha() {
    //캡차 로직 시작: 두 무작위 숫자 생성 및 정답 저장
    int num1 = (int) (Math.random() * 50) + 1; 
    int num2 = (int) (Math.random() * 50) + 1; 

    // 정답을 멤버 변수에 저장
    captchaAnswer = num1 + num2;
    
    // 캡차 문제를 레이블에 표시 
    if (lblCaptchaProblem != null) { 
        lblCaptchaProblem.setText(num1 + " + " + num2 + " = ?");
        // 폰트 스타일 조정
        lblCaptchaProblem.setFont(new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 18));
        lblCaptchaProblem.setForeground(new java.awt.Color(0, 102, 153));
    }
    // 입력 필드 초기화 (txtCaptchaInput 사용)
    if (txtCaptchaInput != null) { 
        txtCaptchaInput.setText("");
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_captcha = new javax.swing.JDialog();
        lblCaptchaProblem = new javax.swing.JLabel();
        txtCaptchaInput = new javax.swing.JTextField();
        btnCaptchaConfirm = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_login_id = new javax.swing.JTextField();
        txt_login_pw = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        duple_confirm = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_pw_confirm = new javax.swing.JTextField();
        txt_pw = new javax.swing.JTextField();
        btn_sign_up = new javax.swing.JButton();

        dialog_captcha.setTitle("보안 문자 입력");
        dialog_captcha.setMinimumSize(new java.awt.Dimension(400, 400));
        dialog_captcha.setModal(true);

        lblCaptchaProblem.setText("jLabel1");

        btnCaptchaConfirm.setText("확인");
        btnCaptchaConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptchaConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_captchaLayout = new javax.swing.GroupLayout(dialog_captcha.getContentPane());
        dialog_captcha.getContentPane().setLayout(dialog_captchaLayout);
        dialog_captchaLayout.setHorizontalGroup(
            dialog_captchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_captchaLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(dialog_captchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_captchaLayout.createSequentialGroup()
                        .addComponent(lblCaptchaProblem)
                        .addGap(18, 18, 18)
                        .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_captchaLayout.createSequentialGroup()
                        .addComponent(btnCaptchaConfirm)
                        .addGap(14, 14, 14))))
        );
        dialog_captchaLayout.setVerticalGroup(
            dialog_captchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_captchaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dialog_captchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaptchaProblem)
                    .addComponent(txtCaptchaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnCaptchaConfirm)
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("아이디  :");

        jLabel9.setText("비밀번호  :");

        btn_login.setText("로그인");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jButton1.setText("프로그램 종료");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txt_login_id, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_login_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_login, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_login_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_login_pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btn_login)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("로그인", jPanel2);

        duple_confirm.setText("중복확인");
        duple_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duple_confirmActionPerformed(evt);
            }
        });

        jLabel4.setText("아이디  :");

        jLabel7.setText("비밀번호  :");

        jLabel8.setText("이름  :");

        jLabel10.setText("비밀번호 확인 :");

        btn_sign_up.setText("회원가입");
        btn_sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sign_upActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txt_pw_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addComponent(duple_confirm)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_sign_up)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duple_confirm)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pw_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sign_up)
                .addGap(124, 124, 124))
        );

        btn_sign_up.getAccessibleContext().setAccessibleName("d");

        jTabbedPane1.addTab("회원가입", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //회원가입
    private void btn_sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sign_upActionPerformed

        //플래그 false시 실행
        if(id_duple_flag == false){
            JOptionPane.showMessageDialog(
                this,
                "아이디의 중복 여부를 확인하지 않았습니다.",
                "아이디 중복 미확인",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String pw = txt_pw.getText(); //비번
        String pw_confirm = txt_pw_confirm.getText(); //비번확인

        //비번이랑 비번확인이랑 같은 지 확인 
        if(pw.equals(pw_confirm) == false)
        {
            //화면에 경고창 띄우기
            JOptionPane.showMessageDialog(
                this, 
                "입력하신 두 비밀번호가 일치하지 않습니다.",
                "비밀번호 불일치",
                JOptionPane.WARNING_MESSAGE);

            //비번이 일치하지 않으면 초기화 후 포커스 
            txt_id.setText("");
            txt_pw.setText("");
            txt_pw_confirm.setText("");
            txt_name.setText("");
            txt_pw_confirm.requestFocusInWindow();
        }
        else {
            strSQL = "insert into Memberinfo values(";
            strSQL += "'"+txt_name.getText()+"',"; // 1. NAME 필드 값
            strSQL += "'"+txt_pw.getText()+"',"; // 2. PASSWORD 필드 값
            strSQL += "'"+txt_id.getText()+"')"; // 3. ID 필드 값
            strSQL = strSQL.toUpperCase();
        }
        try {
            DBM.dbOpen();
            DBM.DB_stmt.executeUpdate(strSQL);
            DBM.dbClose();

            // 성공 메시지 출력
            JOptionPane.showMessageDialog(
                this,
                "회원가입이 완료되었습니다.",
                "성공",
                JOptionPane.INFORMATION_MESSAGE
            );

            txt_id.setText("");
            txt_pw.setText("");
            txt_pw_confirm.setText("");
            txt_name.setText("");
            
            // 회원가입 후 로그인 탭으로 이동:
            jTabbedPane1.setSelectedIndex(0);

        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
            JOptionPane.showMessageDialog(
                this,
                "데이터베이스 오류가 발생했습니다: " + e.getMessage(),
                "오류",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btn_sign_upActionPerformed

    //아이디 중복 확인
    private void duple_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duple_confirmActionPerformed
        String inputId = txt_id.getText().trim();

        // 아이디가 입력되지 않았을 때
        if (inputId.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "아이디를 입력해 주세요.", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
            id_duple_flag = false;
            return;
        }

        //id 비교할 때는 대문자로 해야 됨 
      strSQL = "SELECT ID FROM MEMBERINFO WHERE ID = UPPER('" + inputId + "')";

    try {
        DBM.dbOpen();
        DBM.DB_rs = DBM.DB_stmt.executeQuery(strSQL); 
        
        // 중복 발견
        if (DBM.DB_rs.next()){ 
            JOptionPane.showMessageDialog(this, 
                    "이미 사용중인 아이디 입니다.", 
                    "아이디 중복", 
                    JOptionPane.WARNING_MESSAGE);
            id_duple_flag = false;
        
        // 중복 없음
        } else {
            JOptionPane.showMessageDialog(this, 
                    "사용 가능한 아이디 입니다.", 
                    "사용 가능", 
                    JOptionPane.INFORMATION_MESSAGE);
            id_duple_flag = true;
        }
        DBM.dbClose();

        } catch (Exception e) {
            System.err.println("데이터베이스 오류: " + e.getMessage()); // 에러를 자세히 출력
            JOptionPane.showMessageDialog(this, 
                    "DB 검색 중 오류가 발생했습니다: " + e.getMessage(), 
                    "시스템 오류", 
                    JOptionPane.ERROR_MESSAGE);
            id_duple_flag = false;
        }
    }//GEN-LAST:event_duple_confirmActionPerformed

    //로그인
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
     //로그인을 위해 아이디랑 비번을 받음
     String id = txt_login_id.getText();
     String pw = txt_login_pw.getText();
    
    //ID/PW 유효성 검사 
    if(id.equals("")){
        JOptionPane.showMessageDialog(this, 
                "아이디를 입력하지 않았습니다", 
                "아이디 확인", 
                JOptionPane.WARNING_MESSAGE);
        return;
        
    } else if(pw.equals("")){
        JOptionPane.showMessageDialog(this, 
                "비밀번호를 입력하지 않았습니다", 
                "비빌번호 확인", 
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    generateCaptcha(); // 새 캡차 문제 생성 및 준비
    dialog_captcha.setLocationRelativeTo(this); // 메인 창 중앙에 다이얼로그 표시
    dialog_captcha.setVisible(true); // 캡차 다이얼로그를 모달로 띄우고 사용자의 입력이 완료될 때까지 대기

    // 캡차 다이얼로그가 닫힌 후, 최종 입력값과 정답을 비교하여 확실하게 검증합니다.
    try {
        int finalInputCaptcha = Integer.parseInt(txtCaptchaInput.getText().trim());
        if (finalInputCaptcha != captchaAnswer) {
            // 캡차가 틀렸거나, 입력이 숫자가 아니거나 (X 버튼으로 닫았을 경우)
            JOptionPane.showMessageDialog(this, 
                    "캡차 인증이 완료되지 않았습니다.", 
                    "인증 실패", 
                    JOptionPane.WARNING_MESSAGE);
            return; // 인증 실패 시 로그인 DB 로직 실행 안 함
        }
    } catch (NumberFormatException e) {
        // 캡차 입력 필드가 비어있다면 취소로 간주
        JOptionPane.showMessageDialog(this, 
                "캡차 인증이 취소되었습니다.", 
                "인증 취소", 
                JOptionPane.WARNING_MESSAGE);
        return;
    }
  
    // 캡챠 인증 후 로그인 절차 진행 
    strSQL = "SELECT NAME FROM memberinfo WHERE ID = '" + id + "' AND PASSWORD = '" + pw + "'";
    strSQL = strSQL.toUpperCase();
    
    try {
        DBM.dbOpen();
        DBM.DB_rs = DBM.DB_stmt.executeQuery(strSQL);
        
        //회원정보가 없거나 아이디,비번이 틀릴 때 한 번에 처리함 
        if(DBM.DB_rs.next() == false){
            JOptionPane.showMessageDialog(
            this, 
            "회원정보가 일치하지 않습니다", 
            "로그인 정보", 
            JOptionPane.WARNING_MESSAGE);
        } else {
            String loggedInUserName = DBM.DB_rs.getString("NAME"); // DB에서 이름 가져오기
            
            //여기에서 메인화면으로 갈 때 생성자를 사용해서 사용자 이름을 가져감 -> xxx님 안녕하세요 ! 표시할려고
            MainFrame mainFrame = new MainFrame(loggedInUserName);
            mainFrame.setVisible(true);//메인 화면으로 전환
    
            // 2. 현재 로그인 창 닫기
            this.dispose();
        }
        DBM.DB_rs.close(); // ResultSet 닫기
        DBM.dbClose(); // DB 연결 닫기
        
    } catch (Exception e) {
        System.out.println("SQLException: " + e.getMessage());
        JOptionPane.showMessageDialog(
            this, "데이터베이스 오류가 발생했습니다: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btn_loginActionPerformed

    //캡차 유효성 검사후 화면 닫기
    private void btnCaptchaConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptchaConfirmActionPerformed
        String input = txtCaptchaInput.getText().trim();
        int userInputCaptcha;

        // 입력값 유효성 검사 (숫자인지 확인)
        try {
            userInputCaptcha = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(dialog_captcha, 
                    "숫자로 입력해 주세요.", 
                    "입력 오류", 
                    JOptionPane.WARNING_MESSAGE);
            txtCaptchaInput.setText("");
            return;
        }

        //캡차 정답 비교 로직
        if (userInputCaptcha == captchaAnswer) {
            // 캡차 성공: 다이얼로그 닫기
            dialog_captcha.dispose(); 
            
        } else {
            // 캡차 실패: 경고 메시지 출력 및 새 문제 생성
            JOptionPane.showMessageDialog(dialog_captcha, 
                    "캡차 정답이 틀렸습니다. 다시 시도해 주세요.", 
                    "캡차 오류", 
                    JOptionPane.WARNING_MESSAGE);
            generateCaptcha(); // 새 캡차 문제 생성
        }       
    }//GEN-LAST:event_btnCaptchaConfirmActionPerformed
    
    //프로그램 종료 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
        java.awt.EventQueue.invokeLater(() -> new sign_login_mainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaptchaConfirm;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_sign_up;
    private javax.swing.JDialog dialog_captcha;
    private javax.swing.JButton duple_confirm;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCaptchaProblem;
    private javax.swing.JTextField txtCaptchaInput;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_login_id;
    private javax.swing.JTextField txt_login_pw;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_pw;
    private javax.swing.JTextField txt_pw_confirm;
    // End of variables declaration//GEN-END:variables
}
