package MusicGui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import MusicPlay.Mp3Play;

//层次：窗口-》面板-》（->滚动条-》）列表
public class SongSheet {
	JFrame f;
	JList list;
	DefaultComboBoxModel jListModel;
	public SongSheet(){
		f=new JFrame();
		f.setLayout(null);//再通过setBounds自定义组件位置
		f.setBounds(50,50,800,600);
		Container container=f.getContentPane();
		
		String s[]= {};
		jListModel = new DefaultComboBoxModel(s);  //数据模型
		list=new JList(jListModel);
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(50, 50, 300, 400);
		jsp.setViewportView(list);//将列表增加到滚动窗口中（不能直接用add）
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		container.add(jsp);
		list.setBorder(BorderFactory.createTitledBorder("歌单"));
		list.setBackground(Color.pink);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount()==2) {
					String songName="D:/kugou/";
					songName+=list.getSelectedValue()+".mp3";
					System.out.println(songName);
					Mp3Play mp3=new Mp3Play(songName);
					mp3.play();
				}
			}
		});
	}
	public void addSong(String pathName) {//增加到歌单上;//歌曲路径名
		String songName;
		int a,b;
		a=pathName.lastIndexOf('\\');
		b=pathName.lastIndexOf('.');
		songName=pathName.substring(a+1, b);//只保留文件名
		//System.out.println(songName);
		jListModel.addElement(songName);

	}

}

