import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('početna', {path: '/'}); //Ucitava pocetnu stranicu pri prvom ulasku na stranicu
  this.route('pregledpatrola');
  this.route('pomoć');
  this.route('onama');
  this.route('kontakt');
  this.route('prijava');
  this.route('registracija');
  this.route('prikazkomentara');
  this.route('prikazkorisnika');
  this.route('prikazadmina');
  this.route('novapatrola');
});
export default Router;
