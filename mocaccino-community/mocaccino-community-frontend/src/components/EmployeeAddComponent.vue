<template>
  <section>
    <b-button 
      variant="outline-primary" 
      @click="showModalDetail">add employee</b-button>
    <b-button 
      variant="outline-secondary" 
      @click="updateView">update view</b-button>
    <b-modal ref="modal-add" hide-footer title="enter the details of a new employee">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent="onSubmitForm">
          <!-- username field -->
          <b-form-group id="input-username-group" label="username" label-for="input-username">
            <b-form-input 
              id="input-username" 
              name="input-username" 
              v-model="$v.form.employeeUsername.$model" 
              :state="onValidateFormEmployeeUsername('employeeUsername')" 
              aria-describedby="input-username-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-username-feedback-invalid">
              must be 6 to 20 characters long; moreover only numeric and alphabetic characters are accepted, both uppercase and lowercase
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-username-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input 
              id="input-name" 
              name="input-name" 
              v-model="$v.form.employeeName.$model" 
              :state="onValidateFormEmployeeName('employeeName')" 
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              must be 3 to 14 characters long; moreover only alphabetic characters are accepted, both uppercase and lowercase
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- surname field -->
          <b-form-group id="input-surname-group" label="surname" label-for="input-surname">
            <b-form-input 
              id="input-surname" 
              name="input-surname" 
              v-model="$v.form.employeeSurname.$model" 
              :state="onValidateFormEmployeeSurname('employeeSurname')" 
              aria-describedby="input-surname-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-surname-feedback-invalid">
              must be 3 to 20 characters long; moreover only alphabetic characters are accepted, both uppercase and lowercase
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-surname-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- email field -->
          <b-form-group id="input-email-group" label="email" label-for="input-email">
            <b-form-input 
              id="input-email" 
              name="input-email" 
              v-model="$v.form.employeeEmail.$model" 
              :state="onValidateFormEmployeeEmail('employeeEmail')" 
              aria-describedby="input-email-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-email-feedback-invalid">
              must be 8 to 60 characters long
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-email-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- profession field -->
          <b-form-group id="input-profession-group" label="profession" label-for="input-profession">
            <b-form-input 
              id="input-profession" 
              name="input-profession" 
              v-model="$v.form.employeeProfession.$model" 
              :state="onValidateFormEmployeeProfession('employeeProfession')" 
              aria-describedby="input-profession-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-profession-feedback-invalid">
              must be 5 to 30 characters long; moreover only alphabetic and dash characters are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-profession-feedback-valid">
              all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- buttons -->
          <b-button 
            class="mt-3" 
            variant="outline-secondary" 
            block 
            @click="hideModalDetail">cancel</b-button>
          <b-button 
            class="mt-3" 
            variant="outline-warning" 
            block 
            @click="onResetForm()">reset</b-button>
          <b-button 
            class="mt-3" 
            variant="outline-primary" 
            block 
            type="submit">save</b-button>
        </b-form>
      </div>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { 
  required, 
  minLength, 
  maxLength, 
  alpha, 
  alphaNum, 
  email, 
  helpers
 } from 'vuelidate/lib/validators'
import EmployeeVerbsRestfulService from '../services/EmployeeVerbsRestfulService'

const employeeProfessionRegex = helpers.regex('employeeProfessionRegex', /^[a-zA-Z-]*$/);

export default {
  name: 'EmployeeAddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      employeeUsername: '',
      employeeName: '',
      employeeSurname: '',
      employeeEmail: '',
      employeeProfession: ''
    }
  }),
  validations: {
    form: {
      employeeUsername: {
        required,
        minLength: minLength(6),
        maxLength: maxLength(20),
        alphaNum
      },
      employeeName: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(14),
        alpha
      },
      employeeSurname: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(20),
        alpha
      },
      employeeEmail: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(60),
        email
      },
      employeeProfession: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(30),
        employeeProfessionRegex
      }
    }
  },
  methods: {
    onValidateFormEmployeeUsername(employeeUsername) {
      const { $dirty, $error } = this.$v.form[employeeUsername];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeName(employeeName) {
      const { $dirty, $error } = this.$v.form[employeeName];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeSurname(employeeSurname) {
      const { $dirty, $error } = this.$v.form[employeeSurname];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeEmail(employeeEmail) {
      const { $dirty, $error } = this.$v.form[employeeEmail];
      return $dirty ? !$error : null;
    },
    onValidateFormEmployeeProfession(employeeProfession) {
      const { $dirty, $error } = this.$v.form[employeeProfession];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        employeeUsername: '',
        employeeName: '',
        employeeSurname: '',
        employeeEmail: '',
        employeeProfession: ''
      };
      this.$nextTick(() => {
        this.$v.$reset();
      });
    },
    onSubmitForm() {
      this.$v.form.$touch();
      if (this.$v.form.$anyError) {
        this.onResetForm();
        return;
      }
      this.onConfirm();
    },
    onConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to add this item', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'warning',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.addEmployee();
        }
      });
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    addEmployee() {
      var data = {
        username: this.form.employeeUsername,
        name: this.form.employeeName,
        surname: this.form.employeeSurname,
        email: this.form.employeeEmail,
        profession: this.form.employeeProfession
      };
      EmployeeVerbsRestfulService.create(data)
        .then(response => {
          console.log(response.data);
        }).catch(e => {
          console.log(e);
        });
      this.$refs['modal-add'].hide();
      this.updateView();
    },
    updateView() {
      this.$emit('updateView');
    }
  }
}
</script>
