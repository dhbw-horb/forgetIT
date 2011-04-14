package forgetit.common;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Function {

	@Id
	@GeneratedValue
	private int id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private forgetit.common.Entity entity_id;

	// x^0....x^n
	@ElementCollection
	@CollectionTable(name = "coefficients")
	@Column(name = "coefficients")
	private List<Integer> coefficients;

	public List<Integer> getCoefficients() {

		return coefficients;
	}

	public void setCoefficients(List<Integer> coefficients) {

		this.coefficients = coefficients;
	}

	public int getY(int x) {

		// TODO implement
		return 0;
	}

}