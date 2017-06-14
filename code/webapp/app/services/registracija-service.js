import BaseService from './base-service';
import Korisnik from '../models/korisnik';

export default BaseService.extend({

    register: function(korisnik) {
        this.ajax({ url: `/korisnici/register`, type: "POST", data: JSON.stringify(korisnik)}).then(function(data) {
        });
    
        return true;
    },
});