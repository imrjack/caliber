/**
 * 
 * @param $log
 * @param barChartFactory
 * @param radarChartFactory
 * @param lineChartFactory
 * @returns {{}}
 */
angular
		.module("delegate")
		.factory(
				"chartsDelegate",
				function($log, barChartFactory, radarChartFactory,
						lineChartFactory) {
					$log.debug("Booted charts delegate");

					var delegate = {};

					delegate.bar = {};
					delegate.doughnut = {};
					delegate.radar = {};
					delegate.line = {};

					/**
					 * ********************* Horizontal Bar
					 * *********************
					 */
					delegate.bar.getBatchAvgChart = function(dataArray) {
						return barChartFactory.getBatchAvgChart(dataArray);
					};

					delegate.bar.getTrainerEvalChart = function(dataArray) {
						return barChartFactory.getTrainerEvalChart(dataArray);
					};

					delegate.bar.getAllBatchesEvalChart = function(dataArray) {
						return barChartFactory
								.getAllBatchesEvalChart(dataArray);
					};

					delegate.bar.getBatchTechEvalChart = function(dataArray) {
						return barChartFactory
								.getBatchTechEvalChart(dataArray);
					};

					/**
					 * ************************** Radar
					 * *************************
					 */
					delegate.radar.getBatchRankComparisonChart = function(
							dataArray) {
						return radarChartFactory
								.getBatchRankComparisonChart(dataArray);
					};

					delegate.radar.getTraineeTechProgressChart = function(
							dataArray) {
						return radarChartFactory
								.getTraineeTechProgressChart(dataArray);
					};

					delegate.radar.getAllBatchRankComparisonChart = function(
							dataArray1, dataArray2) {
						return radarChartFactory
								.getAllBatchRankComparisonChart(dataArray1,
										dataArray2);
					};

					/**
					 * ************************** Line
					 * **************************
					 */
					delegate.line.getTraineeProgressChart = function(dataArray) {
						return lineChartFactory
								.getTraineeProgressChart(dataArray);
					};

					delegate.line.getBatchProgressChart = function(dataArray) {
						return lineChartFactory
								.getBatchProgressChart(dataArray);
					};

					return delegate;
				});