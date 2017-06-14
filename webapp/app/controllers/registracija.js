import Ember from 'ember';

export default Ember.Controller.extend({
	// registracijaService: Ember.inject.service(),

	// register: function(korisnik) {
		
    //     this.get('registracija-service').register(korisnik);
	// 	alert("nesto");
    // },

    actions: {
    	register: function(){
			//validacija
			var regName = /^[a-zA-Z]+$/;
			var regUsername=/^[a-zA-Z0-9]+$/;
			var wasError=false;
			if(!this.get('ime').match(regName))
			{
				this.set('errorName','Ime može sadržavati samo slova!');
				wasError=true;
			}
			if(!this.get('username').match(regUsername))
			{
				this.set('errorUsername','Username se mora sastojati samo od slova i brojeva!');
				wasError=true;
			}
			else
			this.set('errorUsername','');	
            var regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			if(!this.get('email').match(regEmail))
			{
				this.set('errorEmail','Email treba biti u formatu example@something.com!');
				wasError=true;
			}
			else
			this.set('errorEmail','');
			var regPassword = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
			if(!this.get('password').match(regPassword))
			{
				this.set('errorPassword','Password mora imati makar jedno veliko slovo, malo slovo, broj i minimalno 6 karaktera!');
				wasError=true;
			}
			else this.set('errorPassword','');
			if(this.get('password')!=this.get('model.confirmedPassword'))
			{
				this.set('errorConfirmedPassword','Passwordi se ne podudaraju!');
				wasError=true;
			}
			else this.set('errorConfirmedPassword','');
			
			
			
			
			if(!wasError)
			{
			
			let podaci=JSON.stringify({
					//'korisnik' : {
						ime:  this.get('ime'),
						username:  this.get('username'),
						password: this.get('password'),
						email: this.get('email'),
						broj_tacnih_prijava: 0,
						broj_netacnih_prijava: 0,
						admin: 0
						//super-admin: 0
					//} 
				});
			Ember.$.ajax({
				url: "http://localhost:8080/korisnici/register",
				type: "POST",
				contentType: "application/json",
				data: podaci
			}).then(() => {
				alert("Registracija uspjela");
			}).catch(function(error) {
				alert(error.error);
    		  });

			}
			// let korisnik = this.getProperties('ime', 'username', 'password', 'email');
			
			// this.register(korisnik);
    	}
    }
});