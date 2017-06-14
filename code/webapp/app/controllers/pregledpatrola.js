import Ember from 'ember';

export default Ember.Controller.extend({
	ajax: Ember.inject.service(),
    actions: {
    	uklonipatrolu: function(id){
			this.get('ajax').request('http://localhost:8080/patrole/delete?id='+id, { method: 'GET' });
    	}
		,
		dodajpatrolu: function(id){
			window.open('novapatrola');
			}
    }
});