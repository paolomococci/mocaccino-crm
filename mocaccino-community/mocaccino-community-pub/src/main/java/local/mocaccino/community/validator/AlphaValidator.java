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

package local.mocaccino.community.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import local.mocaccino.community.validator.constraint.AlphaConstraint;

public class AlphaValidator 
		implements ConstraintValidator<AlphaConstraint, String> {

	@Override
	public void initialize(AlphaConstraint constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }
        if (value.matches("[a-zA-Z]+")) {
            return true;
        }
        else {
            return false;
        }
	}
}
