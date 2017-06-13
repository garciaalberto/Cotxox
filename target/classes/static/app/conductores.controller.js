
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
        //vm.getFiables = getFiables;
        vm.getRandom = getRandom;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = "/poolConductores/all";
            var conductorPromise = $http.get(url);
            conductorPromise.then(function (response) {
                vm.conductores = response.data;
            });
        }

//        function getFiables() {
//            var url = "/poolConductores/Fiables/" + 3.0;
//            var conductorPromise = $http.get(url);
//            conductorPromise.then(function (response) {
//                vm.conductores = response.data;
//            });
//        }

        function getRandom() {
            var url = "/poolConductores/random";
            var conductorPromise = $http.get(url);
            conductorPromise.then(function (response) {
                vm.conductores = response.data;
            });
        }
//        function deleteConductor(id) {
//            var url = "/poolConductores/delete/" + id;
//            $http.post(url).then(function (response) {
//                vm.conductores = response.data;
//            });
//        }
    }
})();
