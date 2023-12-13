package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.HaisanDAO;
import dao.LoaihaisanDAO;
import model.Loaihaisan;
import model.Haisan;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class formHaisan extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JCheckBox cbTuoiSong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtXuatXu;
	private JTextField txtDVT;
	private JComboBox cbbLHS;

	DefaultTableModel model = new DefaultTableModel();
	List<Loaihaisan> dsLHS = new ArrayList<Loaihaisan>();
	LoaihaisanDAO daoLHS = new LoaihaisanDAO();
	List<Haisan> dsHS = new ArrayList<Haisan>();
	HaisanDAO daoHS = new HaisanDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formHaisan frame = new formHaisan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formHaisan() {
		initGUI();
		//
		table.setModel(model);
		model.addColumn("MÃ");
		model.addColumn("TÊN");
		model.addColumn("XUẤT XỨ");
		model.addColumn("ĐVT");
		model.addColumn("TƯƠI SỐNG");
		model.addColumn("LOẠI");
		//
		dsLHS = daoLHS.findALL();
		dsHS = daoHS.findALL();
		for (Haisan s : dsHS) {

			Object[] o = { s.getMa(), s.getTen(), s.getXuatxu(), s.getDonvitinh(), s.isTuoisong(),
					s.getLoaihaisan().getTen() };
			model.addRow(o);
		}
		int i = 1;
		for (Loaihaisan l : dsLHS) {

			cbbLHS.addItem(i + "-" + l.getTen());
			i++;
//			for(Sinhvien s:l.getSinhviens())
//			{
//				Object[] o = {s.getMssv(),s.getHoten(),s.getDtb(),s.getLop().getTenlop()};
//				model.addRow(o);
//			}
		}
		//

	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_2());
		contentPane.add(getLblNewLabel_1_3());
		contentPane.add(getLblNewLabel_1_4());
		contentPane.add(getCbTuoiSong());
		contentPane.add(getBtnThem());
		contentPane.add(getBtnXoa());
		contentPane.add(getBtnSua());
		contentPane.add(getTxtMa());
		contentPane.add(getTxtTen());
		contentPane.add(getTxtXuatXu());
		contentPane.add(getTxtDVT());
		contentPane.add(getCbbLHS());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 183, 416, 134);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table.getSelectedRow();
					if (index != -1) {
						Haisan hs = dsHS.get(index);
						txtMa.setText("" + hs.getMa());
						txtTen.setText(hs.getTen());
						txtXuatXu.setText(hs.getXuatxu());
						txtDVT.setText(hs.getDonvitinh());
						int j = 0;
						for (Loaihaisan a : dsLHS) {
							if (hs.getLoaihaisan().getTen().compareTo(a.getTen()) == 0) {
								cbbLHS.setSelectedIndex(j);
							}
							j++;
						}
						if (hs.isTuoisong()) {
							cbTuoiSong.setSelected(true);
						} else {
							cbTuoiSong.setSelected(false);
						}
					}
				}
			});
		}
		return table;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("QU\u1EA2N L\u00DD H\u1EA2I S\u1EA2N");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 10, 416, 29);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("M\u00E3:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 49, 45, 13);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("T\u00EAn:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(131, 49, 45, 13);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Xu\u1EA5t x\u1EE9:");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_2.setBounds(10, 88, 54, 13);
		}
		return lblNewLabel_1_2;
	}

	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("\u0110\u01A1n v\u1ECB t\u00EDnh:");
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_3.setBounds(195, 88, 70, 13);
		}
		return lblNewLabel_1_3;
	}

	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("Lo\u1EA1i h\u1EA3i s\u1EA3n:");
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_4.setBounds(10, 125, 70, 13);
		}
		return lblNewLabel_1_4;
	}

	private JCheckBox getCbTuoiSong() {
		if (cbTuoiSong == null) {
			cbTuoiSong = new JCheckBox("T\u01B0\u01A1i s\u1ED1ng");
			cbTuoiSong.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbTuoiSong.setBounds(249, 125, 93, 21);
		}
		return cbTuoiSong;
	}

	private JButton getBtnThem() {
		if (btnThem == null) {
			btnThem = new JButton("Th\u00EAm");
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Loaihaisan lhs = new Loaihaisan();
						Object o = cbbLHS.getSelectedItem();
						String tenLHS = o.toString();
						tenLHS = tenLHS.substring(2);
						for (Loaihaisan l : dsLHS) {
							if (l.getTen().compareTo(tenLHS) == 0) {
								lhs = l;
							}
						}
						if (txtTen.getText().compareTo("") != 0) {
							if (txtXuatXu.getText().compareTo("") != 0) {
								if (txtDVT.getText().compareTo("") != 0) {
									Haisan s = new Haisan(lhs, txtTen.getText(), txtXuatXu.getText(), txtDVT.getText(),
											cbTuoiSong.isSelected());
									if (daoHS.add(s)) {
										dsHS.add(s);
										Object[] o1 = { s.getMa(), s.getTen(), s.getXuatxu(), s.getDonvitinh(),
												s.isTuoisong(), s.getLoaihaisan().getTen() };
										model.addRow(o1);
										JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
									} else {
										JOptionPane.showMessageDialog(null, "Thêm thất bại!!!");
									}
								} else {
									JOptionPane.showMessageDialog(null, "Vui lòng điền ĐVT!!!");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Vui lòng điền xuất xứ!!!");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Vui lòng điền tên!!!");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!!!");
					}
				}
			});
			btnThem.setBounds(195, 152, 70, 21);
		}
		return btnThem;

	}

	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("X\u00F3a");
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table.getSelectedRow();
					if (index != -1) {
						Haisan sv = dsHS.get(index);
						if (daoHS.delete(sv.getMa())) {
							dsHS.remove(index);
							model.removeRow(index);
							JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
							txtMa.setText("");
							txtTen.setText("");
							txtXuatXu.setText("");
							txtDVT.setText("");
							cbbLHS.setSelectedIndex(0);
							cbTuoiSong.setSelected(false);
						} else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại!!!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn SV cần xóa!!!");
					}
				}
			});
			btnXoa.setBounds(281, 152, 61, 21);
		}
		return btnXoa;
	}

	private JButton getBtnSua() {
		if (btnSua == null) {
			btnSua = new JButton("S\u1EEDa");
			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table.getSelectedRow();
					try
					{
						if(index!=-1)
						{
							Haisan hs = dsHS.get(index);
							if(txtTen.getText().compareTo("")!=0)
							{
								if(txtXuatXu.getText().compareTo("")!=0)
								{
									if(txtDVT.getText().compareTo("")!=0)
									{
										hs.setTen(txtTen.getText());
										hs.setXuatxu(txtXuatXu.getText());
										hs.setDonvitinh(txtDVT.getText());
										Object o = cbbLHS.getSelectedItem();
										String tenLHS = o.toString();
										tenLHS = tenLHS.substring(2);
										Loaihaisan lhs = new Loaihaisan();
										for(Loaihaisan l:dsLHS)
										{
											if(l.getTen().compareTo(tenLHS)==0)
											{
												lhs = l;
											}
										}
										hs.setLoaihaisan(lhs);
										hs.setTuoisong(cbTuoiSong.isSelected());
										if(daoHS.update(hs))
										{
											dsHS.set(index, hs);
											model.setRowCount(0);
											for(Haisan hs1:dsHS)
											{
												Object[] o1 = { hs1.getMa(), hs1.getTen(), hs1.getXuatxu(), hs1.getDonvitinh(),
														hs1.isTuoisong(), hs1.getLoaihaisan().getTen() };
												model.addRow(o1);
											}
											JOptionPane.showMessageDialog(null, "Sửa thành công!!!");
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Vui lòng điền ĐVT!!!");
									}
								}
								else 
								{
									JOptionPane.showMessageDialog(null, "Vui lòng điền xuất xứ!!!");
								}
							} 
							else 
							{
								JOptionPane.showMessageDialog(null, "Vui lòng điền tên!!!");
							}
						} 
						else
						{
							JOptionPane.showMessageDialog(null, "Vui chọn hải sản cần sửa!!!");
						}
					}
					catch (Exception e1) 
					{
						JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");
					}
				}
			});
			btnSua.setBounds(356, 152, 70, 21);
		}
		return btnSua;
	}

	private JTextField getTxtMa() {
		if (txtMa == null) {
			txtMa = new JTextField();
			txtMa.setEnabled(false);
			txtMa.setBounds(38, 47, 70, 19);
			txtMa.setColumns(10);
		}
		return txtMa;
	}

	private JTextField getTxtTen() {
		if (txtTen == null) {
			txtTen = new JTextField();
			txtTen.setColumns(10);
			txtTen.setBounds(171, 47, 255, 19);
		}
		return txtTen;
	}

	private JTextField getTxtXuatXu() {
		if (txtXuatXu == null) {
			txtXuatXu = new JTextField();
			txtXuatXu.setColumns(10);
			txtXuatXu.setBounds(65, 86, 96, 19);
		}
		return txtXuatXu;
	}

	private JTextField getTxtDVT() {
		if (txtDVT == null) {
			txtDVT = new JTextField();
			txtDVT.setColumns(10);
			txtDVT.setBounds(266, 86, 160, 19);
		}
		return txtDVT;
	}

	private JComboBox getCbbLHS() {
		if (cbbLHS == null) {
			cbbLHS = new JComboBox();
			cbbLHS.setBounds(90, 122, 123, 21);
		}
		return cbbLHS;
	}
}
