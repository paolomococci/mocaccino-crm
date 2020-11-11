/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.mocaccino.community.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import local.mocaccino.community.validator.constraint.AlphaConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE",
		uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME"}))
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@AlphaConstraint
	private String name;

	@AlphaConstraint
	private String surname;

	@AlphaConstraint
	private String email;

	@AlphaConstraint
	private String profession;

	private String username;
}