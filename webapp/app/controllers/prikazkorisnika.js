import Ember from 'ember';

export default Ember.Controller.extend({
	ajax: Ember.inject.service(),
    actions: {
    	blokirajkorisnika: function(id){
			this.get('ajax').request('http://localhost:8080/korisnici/delete?id='+id, { method: 'GET' });
			window.reload();
    	}
		
    }
});