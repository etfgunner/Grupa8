import Ember from 'ember';

export default Ember.Controller.extend({
	ajax: Ember.inject.service(),
    actions: {
    	dodajpatrolu: function(id){
			let podaci=JSON.stringify({
					//'korisnik' : {
						id_korisnika:  1,
						id_lokacije:id ,
						vrijeme_prijave:Date(),
						ispravnost_prijave:1
					//} 
				});
			Ember.$.ajax({
				url: "http://localhost:8080/patrole/add",
				type: "POST",
				contentType: "application/json",
				data: podaci
			}).then(() => {
				alert("Uspjelo dodavanje patrole");
			}).catch(function(error) {
				alert(error.error);
    		  });
    	}
		
	}
});