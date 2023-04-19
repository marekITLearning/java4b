package sk.itlearning.java4.a.abc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Obcan implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	private String rodneCislo;

	private String meno;

	private BigDecimal kredit;

	public String getRodneCislo() {
		return rodneCislo;
	}

	public Obcan(String rodneCislo, String meno) {
		setRodneCislo(rodneCislo);
		setMeno(meno);
	}

	public void setRodneCislo(String rodneCislo) {
		rodneCislo = rodneCislo.replace("/", "");
		long rcc = Long.valueOf(rodneCislo);
		if (rcc % 11 == 0) {
			this.rodneCislo = rodneCislo;
		} else {
			throw new IllegalArgumentException("Zadali ste neplatne rodne cislo");
		}
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public BigDecimal getKredit() {
		return kredit;
	}

	public void setKredit(BigDecimal kredit) {
		this.kredit = kredit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Obcan) {
			Obcan o = (Obcan) obj;
			return Objects.equals(this.rodneCislo, o.rodneCislo) && Objects.equals(this.meno, o.meno)
					&& Objects.equals(this.kredit, o.kredit);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.rodneCislo, this.meno, this.kredit);
	}

	@Override
	public String toString() {
		return "Zakaznik; typ Obcan; RC = " + rodneCislo + "; Meno = " + meno;
	}
	
	@Override
	public Obcan clone() {
		try {
			return (Obcan) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public Obcan clone() {
//		Obcan o = new Obcan(this.rodneCislo, this.meno);
//		o.setKredit(this.getKredit());
//		return o;
//	}

	
}
