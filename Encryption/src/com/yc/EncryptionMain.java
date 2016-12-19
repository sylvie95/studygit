package com.yc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * 
 * @author Lin ShiYou
 *
 */
public class EncryptionMain {

	protected Shell shell;
	private Composite composite;
	private Composite composite_welcome;
	private Composite composite_menu;
	private Composite composite_help;
	private StackLayout stackLayout = new StackLayout();
	private MenuItem menuItem_welcome;
	private MenuItem menuItem_menu;
	private MenuItem menuItem_help;
	private Text text_miyue;
	private Text text_xuhao;		//变换列序
	private Text text_wenben;
	private Text text_result;
	private Button button;			// 加密   解密   按钮
	private Button button_xuanze;	//选择文件按钮
	private Button button_txt;		// 加密类型 :  文档
	private Button button_context;	// 加密类型 :  文本
	private Combo combo_suanfa;		//	算法类型选择 : 变换加密
	private Combo combo_leixing;	//操作类型 : 加密	解密
	private Label lblCopyright;
	
	//RSA算法
	private Composite composite_RSA ;
	private MenuItem mntmRsa;
	private Button RSA_button;	//RSA算法加密按钮
	private Label RSA_result;	//RSA算法加解密处理结果
	private Button RSA_jiami;	//RSA算法 	选择加密
	private Button RSA_jiemi;	//RSA算法 	选择解密
	
	
	
	private Label label_5;
	private Text RSA_mingwen;
	private Text text_1;
	private Composite shiyongshuoming;
	private MenuItem menuItem_1;
	private Label label_7;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EncryptionMain window = new EncryptionMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.MIN|SWT.CLOSE);
		shell.setSize(545, 373);
		shell.setText("信息加解密系统");
		
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation((dem.width-shell.getSize().x)/2,(dem.height-shell.getSize().y)/2);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("文件");
		
		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);
		
		menuItem_welcome = new MenuItem(menu_1, SWT.NONE);
		menuItem_welcome.setText("首页");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.CASCADE);
		menuItem_2.setText("功能");
		
		Menu menu_2 = new Menu(menuItem_2);
		menuItem_2.setMenu(menu_2);
		
		menuItem_menu = new MenuItem(menu_2, SWT.NONE);
		menuItem_menu.setText("变位加密");
		
		mntmRsa = new MenuItem(menu_2, SWT.NONE);
		mntmRsa.setText("RSA算法加密");
		
		MenuItem menuItem_4 = new MenuItem(menu, SWT.CASCADE);
		menuItem_4.setText("帮助");
		
		Menu menu_3 = new Menu(menuItem_4);
		menuItem_4.setMenu(menu_3);
		
		menuItem_1 = new MenuItem(menu_3, SWT.NONE);
		menuItem_1.setText("使用说明");
		
		menuItem_help = new MenuItem(menu_3, SWT.NONE);
		menuItem_help.setText("关于");
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setBounds(0, 0, 537, 324);
		
		composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(stackLayout);
		
		composite_welcome = new Composite(composite, SWT.NONE);
		composite_welcome.setBackgroundImage(SWTResourceManager.getImage(EncryptionMain.class,"/images/background1.jpg"));
		stackLayout.topControl = composite_welcome;
		composite.layout();
		
		composite_menu = new Composite(composite, SWT.NONE);
		
		Label label = new Label(composite_menu, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label.setBounds(30, 22, 40, 19);
		label.setText("算法 : ");
		
		combo_suanfa = new Combo(composite_menu, SWT.NONE);
		combo_suanfa.setItems(new String[] {"矩阵变换"});
		combo_suanfa.setBounds(76, 21, 101, 25);
		combo_suanfa.setText("矩阵变换");
		
		Label label_1 = new Label(composite_menu, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_1.setBounds(225, 24, 35, 17);
		label_1.setText("密钥 : ");
		
		text_miyue = new Text(composite_menu, SWT.BORDER);
		text_miyue.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text_miyue.setBounds(266, 23, 60, 23);
		
		Label label_2 = new Label(composite_menu, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_2.setText("操作类型 : ");
		label_2.setBounds(362, 24, 63, 17);
		
		combo_leixing = new Combo(composite_menu, SWT.NONE);
		combo_leixing.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		combo_leixing.setItems(new String[] {"加密", "解密"});
		combo_leixing.setBounds(435, 19, 80, 27);
		combo_leixing.setText("加密");
		
		Label label_3 = new Label(composite_menu, SWT.NONE);
		label_3.setText("变换列序 : ");
		label_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_3.setBounds(33, 67, 63, 17);
		
		text_xuhao = new Text(composite_menu, SWT.BORDER);
		text_xuhao.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text_xuhao.setBounds(102, 65, 73, 25);
		
		Label label_4 = new Label(composite_menu, SWT.NONE);
		label_4.setBounds(211, 67, 127, 19);
		label_4.setText("请选择加密内容类型 : ");
		
		button_context = new Button(composite_menu, SWT.RADIO);
		button_context.setSelection(true);
		button_context.setBounds(348, 67, 45, 17);
		button_context.setText("文本");
		
		button_txt = new Button(composite_menu, SWT.RADIO);
		button_txt.setBounds(412, 67, 63, 17);
		button_txt.setText("文档");
		
		label_5 = new Label(composite_menu, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_5.setBounds(30, 113, 185, 19);
		label_5.setText("请输入加密文本  :");
		
		text_wenben = new Text(composite_menu, SWT.BORDER);
		text_wenben.setBounds(30, 141, 485, 25);
		
		button_xuanze = new Button(composite_menu, SWT.NONE);
		button_xuanze.setBounds(343, 178, 80, 27);
		button_xuanze.setText("选择文件");
		
		button = new Button(composite_menu, SWT.NONE);
		button.setBounds(438, 178, 54, 27);
		button.setText("加密");
		
		Label label_6 = new Label(composite_menu, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_6.setBounds(30, 216, 173, 19);
		label_6.setText("处理的结果为 :");
		
		text_result = new Text(composite_menu, SWT.BORDER|SWT.WRAP|SWT.H_SCROLL|SWT.V_SCROLL|SWT.CANCEL|SWT.MULTI);
		text_result.setBounds(23, 242, 492, 70);
		
		composite_help = new Composite(composite, SWT.NONE);
		
		lblCopyright = new Label(composite_help, SWT.NONE);
		lblCopyright.setBounds(159, 136, 208, 24);
		lblCopyright.setText("Copyright © 2016 by Lin ShiYou");
		
		composite_RSA = new Composite(composite, SWT.NONE);
		
		Label RSA_mingwen1 = new Label(composite_RSA, SWT.NONE);
		RSA_mingwen1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		RSA_mingwen1.setBounds(32, 51, 42, 22);
		RSA_mingwen1.setText("明文 : ");
		
		RSA_mingwen = new Text(composite_RSA, SWT.BORDER);
		RSA_mingwen.setBounds(80, 51, 422, 22);
		
		RSA_jiami = new Button(composite_RSA, SWT.RADIO);
		RSA_jiami.setSelection(true);
		RSA_jiami.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		RSA_jiami.setBounds(32, 98, 53, 17);
		RSA_jiami.setText("加密");
		
		RSA_jiemi = new Button(composite_RSA, SWT.RADIO);
		RSA_jiemi.setText("解密");
		RSA_jiemi.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		RSA_jiemi.setBounds(104, 98, 53, 17);
		
		RSA_result = new Label(composite_RSA, SWT.NONE);
		RSA_result.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		RSA_result.setBounds(32, 144, 112, 22);
		RSA_result.setText("加密处理结果为 : ");
		
		text_1 = new Text(composite_RSA, SWT.BORDER|SWT.WRAP|SWT.H_SCROLL|SWT.V_SCROLL|SWT.CANCEL|SWT.MULTI);
		text_1.setBounds(32, 172, 475, 142);
		
		RSA_button = new Button(composite_RSA, SWT.NONE);
		RSA_button.setBounds(422, 88, 80, 27);
		RSA_button.setText("加密");
		
		shiyongshuoming = new Composite(composite, SWT.NONE);
		
		label_7 = new Label(shiyongshuoming, SWT.NONE);
		label_7.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_7.setBounds(37, 34, 453, 22);
		label_7.setText("1. 暂无详细使用说明明");
		sashForm.setWeights(new int[] {1});

		
		//
		JJM();
	}
	
	
	private void JJM() {
		//使用说明
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = shiyongshuoming;
				composite.layout();
			}
		});
		
		//RSA算法处理
		RSA_button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String str_RSA = RSA_mingwen.getText();
				try {
					RSA.generateKey(); 
					if(RSA_jiami.getSelection() == true){
						RSA.encrypt(str_RSA);
					}else{
						RSA.decrypt(str_RSA);  
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}  
				
			}
		});
		
		//RSA算法加密按钮
		mntmRsa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageUtil.promt(shell, "提示",	 "此功能尚未开发完全...");
//				stackLayout.topControl = composite_RSA;
//				composite.layout();
			}
		});
		
		//帮助    关于按钮
		menuItem_help.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_help;
				composite.layout();
			}
		});
		
		//判断是否为文本加密
		button_context.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(button_context.getSelection() == true){
					label_5.setText("请输入加密文本  :");
				}else{
					label_5.setText("请输入解密文本  :");
				}
			}
		});
		
		//判断是否为文档加密
		button_txt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(button_txt.getSelection() == true){
					label_5.setText("请选择加密文件  :");
				}else{
					label_5.setText("请选择解密文件  :");
				}
				button_xuanze.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						FileDialog fg=new FileDialog(shell.getShell(),SWT.MULTI);
						//设置对话框标题
						fg.setFilterPath("SystemRoot");//当前文件路径			
						fg.setFilterExtensions(new String[]{"*.txt","*.sql","*.java","*.*"});		
						String selected =fg.open();
						if(selected != null){
							text_wenben.setText(selected);
							StaticUtil.fileName = fg.getFileName();
							StaticUtil.filePath = fg.getFilterPath();
							System.out.println("当前路径是 : " + fg.getFilterPath());
							System.out.println("文件名是 : " + StaticUtil.fileName);
						}else{
							return; 
						}
//						StaticUtil.JM_fileName = selected;
					}
				});
				
			}
		});
		
		//变位加密按钮
		menuItem_menu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_menu;
				composite.layout();
			}
		});
		
		//首页按钮
		menuItem_welcome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = composite_welcome;
				composite.layout();
			}
		});
		
		//选择操作类型 :  1.加密    2.解密
		combo_leixing.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(button_context.getSelection() == true){
					if(combo_leixing.getText().intern().trim() == "加密"){
						button.setText("加密");
						label_5.setText("请输入加密文本  :");
					}else{
						button.setText("解密");
						label_5.setText("请输入解密文本  :");
					}
				}else{
					if(combo_leixing.getText().intern().trim() == "加密"){
						button.setText("加密");
						label_5.setText("请选择加密文件  :");
					}else{
						button.setText("解密");
						label_5.setText("请选择解密文件  :");
					}
				}
				
			}
		});
		
		//进行加密解密操作
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_miyue.getText() == null && text_miyue.getText().intern()==""){
					MessageUtil.promt(shell, "提示",	 "密钥不能为空!!!");
				}else{
					if(text_xuhao.getText()=="" ){
						MessageUtil.promt(shell, "提示",	 "请输入列序!!!");
					}else{
						if(text_wenben.getText()=="" && button_context.getSelection() == true){
							MessageUtil.promt(shell, "提示",	 "请输入要加密或解密的文本!!!");
						}
						if(text_wenben.getText()=="" && button_txt.getSelection() == true){
							MessageUtil.promt(shell, "提示",	 "请输入要加密或解密的文档!!!");
						}
					}
				}
				
				if(text_miyue.getText() != null && text_miyue.getText().intern()!=""){
					if(text_xuhao.getText().length() == Integer.parseInt(text_miyue.getText()) && text_xuhao.getText()!="" && text_wenben.getText()!=""){
						JM();
					}else{
						System.out.println("暂时无法输入...");
					}
				}else{
					System.out.println("暂时无法输入...");
				}
			}
		});
	}
	
	//字符串加密
	private void JM(){
		String context = text_wenben.getText();				//文本内容
		StaticUtil.strLength = context.length();
		int miyue = Integer.parseInt(text_miyue.getText());	//加密密钥
		String liexu = text_xuhao.getText();
		
		FileInputStream filein = null;
		FileOutputStream out = null;
		PrintStream p = null;
		if(button_txt.getSelection() == true){
			File f = new File(text_wenben.getText()); //创建文件对象
			if(!f.exists()){
				MessageUtil.promt(shell, "提示",	 "所指定的项目路径不存在");
				return ;
			}
	        try {
	           // 通过文件对象创建文件输入流
	            filein = new FileInputStream(f);
	            //创建写入流
	           if(combo_leixing.getText().intern().trim() == "加密"){
	        	   out=new FileOutputStream(StaticUtil.filePath + "\\" + "加密" + StaticUtil.fileName);
	           }else{
	        	   out=new FileOutputStream(StaticUtil.filePath + "\\" + "解密" + StaticUtil.fileName);
	           }
	            p=new PrintStream(out);
	            
	          //创建字节数组，用于接收从文件中读取的字节
	            byte buf[] = new byte[1024];
	            String instr = ""; //接收字节转化的字符串
	            int length = filein.read(buf);
	            instr = new String(buf,0,length);//将字节转化成字符串   
	            System.out.println(instr);
	            StaticUtil.strLength = instr.length();
	            
	            System.out.println("文档开始进行加密......");
	            context = instr;
	            
	            filein.close();  //关闭输入流
	        } catch (IOException ex) {
	           ex.printStackTrace();
	        }
		}

		
		String Cliexu_1[][] = new String[(int) Math.ceil(StaticUtil.strLength/miyue)+1][miyue];
		String Cliexu_2[][] = new String[(int) Math.ceil(StaticUtil.strLength/miyue)+1][miyue];
		System.out.println("这个矩阵的长度为 " + ((int) Math.ceil(StaticUtil.strLength/miyue)+1) + "X" + miyue);
		int z = 0;
		int n = 0;
		//取到列序 , 存入数组中
		String[] liexus = new String[liexu.length()];
		for(int i = 0; i < liexus.length; i++){
			if(n<liexu.length()){
				System.out.print(liexu.charAt(n));
				liexus[i] = text_xuhao.getText().charAt(n++) + "";
			}else{
				break;
			}
		}
		System.out.println();
		//将输入的内容存入二维数组中
		for(int i = 0; i < Cliexu_1.length; i++){
			for(int j = 0; j < Cliexu_1[i].length; j++){
				if(z<context.length()){
					System.out.print(context.charAt(z));
					Cliexu_1[i][j]  = context.charAt(z++) + "";
				}else{
					Cliexu_1[i][j]  =  " ";
				}
			}
			System.out.println();
		}
		
		String str[]= new String[(int) Math.ceil(context.length()/miyue)+1];
		
		for(int i = 0; i < Cliexu_1.length; i++){
			int a1=miyue-1; 	//加密
			int a2 = 0; 		//解密
			int m = 0;
			for(int j = 0; j < Cliexu_1[i].length; j++){
				if(j==m && m < miyue){
					if(combo_leixing.getText().intern().trim() == "加密".intern()){
							System.out.println("str.length  ==>>" + str.length);
							//将列序倒着输出
							Cliexu_2[i][j] = Cliexu_1[i][(Integer.parseInt(liexus[a2])-1)] + "";
						
					}else{
							System.out.println("str.length  ==>>" + str.length);
							//将列序倒着输出
							Cliexu_2[i][(Integer.parseInt(liexus[a2])-1)] = Cliexu_1[i][j] + "";
					}
					a2++;
					m++;
				}
			}
			System.out.println();
		}
		String str1 = null;
		if(combo_leixing.getText().intern().trim() == "加密".intern()){
			StaticUtil.massageStr = "\n\r文档开始进行加密......      ";
			str1 = StaticUtil.massageStr + "文档加密完成......\n";
		}else{
			StaticUtil.massageStr = "文档开始进行解密......      ";
			str1 = StaticUtil.massageStr + "文档解密完成......\n";
		}
		StaticUtil.massageStr = str1;
		
		String strs = "";
		for(int i = 0; i<Cliexu_2.length; i++){
			for(int j = 0; j < Cliexu_2[i].length; j++ ){
				if(Cliexu_2[i][j] != null){
					strs += Cliexu_2[i][j];
				}else{
					System.out.print(" ");
					strs += " ";
				}
			}
		}
		if(button_txt.getSelection() == true){
			text_result.setText(str1);
			p.print(strs);
		}else{
			text_result.setText(strs);
		}
	}
}
