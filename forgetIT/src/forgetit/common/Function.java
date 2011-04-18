/*
 * Copyright 2011 DHBW Stuttgart Campus Horb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
		try {
			// static priority
			return coefficients.get(0);
		} catch (Exception e) {
			return 0;
		}
	}

}
