package bean;

public class MonHoc {
	
	private int maso_monhoc;
	private String ten_monhoc;
	private int sotinchi;
	
	public MonHoc()
	{
		
	}
	
	public MonHoc (int ma_mon, String ten_mon, int sotinchi)
	{
		super();
		this.setMaso_monhoc(ma_mon);
		this.setTen_monhoc(ten_mon);
		this.setSotinchi(sotinchi);
	}

	public int getMaso_monhoc() {
		return maso_monhoc;
	}

	public void setMaso_monhoc(int maso_monhoc) {
		this.maso_monhoc = maso_monhoc;
	}

	public String getTen_monhoc() {
		return ten_monhoc;
	}

	public void setTen_monhoc(String ten_monhoc) {
		this.ten_monhoc = ten_monhoc;
	}

	public int getSotinchi() {
		return sotinchi;
	}

	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}

	

}
