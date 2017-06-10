
(function () {
    'use strict';

    angular
        .module('app')
        .controller('ConductorsController', ConductorsController);

    ConductorsController.$inject = ['$http'];

    function ConductorsController($http) {
        var vm = this;

        vm.conductores = [];
        vm.getAll = getAll;
        vm.getFiables = getFiables;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/poolConductores/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.conductores = response.data;
            });
        }

        function getFiables(){
            var url = "/bookings/Fiables/" + 3.0;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.conductores = response.data;
            });
        }

//        function deleteBooking(id){
//            var url = "/bookings/delete/" + id;
//            $http.post(url).then(function(response){
//                vm.bookings = response.data;
//            });
//        }
    }
})();
