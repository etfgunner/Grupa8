import Ember from 'ember';
import BaseModel from './base-model';

var _modelProperties = ['id', 'username', 'password', 'ime', 'email', 'broj_tacnih_prijava', 'broj_netacnih_prijava', 'ocjena', 'admin', 'super-admin'];

export default BaseModel.extend({
	modelProperties: _modelProperties,
});