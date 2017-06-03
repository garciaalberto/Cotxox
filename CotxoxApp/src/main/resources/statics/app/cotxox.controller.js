/**
 * Created by dan.geabunea on 3/29/2016.
 */
(function () {
    'use strict';
    angular
            .module('app')
            .controller('ConductorsController', ConductorsController);
 
    ConductorsController.$inject = ['$http'];

    function ConductorsController($http) {
        var vm = this;

        vm.poolConductores = [];
        vm.getAll = getAll;
        vm.getFiables = getFiables;
        vm.eliminarConductor = eliminarConductor;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = "/poolConductores/all";
            var poolConductoresAll = $http.get(url);
            poolConductoresAll.then(function (response) {
                vm.poolConductores = response.data;
            });
        }

        function getFiables() {
            var url = "/poolConductores/Fiables/" + 100;
            var poolConductoresFialbes = $http.get(url);
            poolConductoresFialbes.then(function (response) {
                vm.poolConductores = response.data;
            });
        }

        function eliminarConductor(id) {
            var url = "/poolConductores/eliminar/" + id;
            $http.post(url).then(function (response) {
                vm.poolConductores = response.data;
            });
        }
    }
})();
