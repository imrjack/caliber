/**
 * Delegates API calls to the appropriate API factory
 */
angular.module("delegate").factory("delegateFactory", function($log, trainerFactory, vpFactory, qcFactory) {
	$log.debug("Booted Delegate Factory");
	var delegate = {};
	
	delegate.testTrainerFactory = function(){
		return trainerFactory.test();
	};
	
	delegate.testVPFactory = function(){
		return vpFactory.test();
	};
	
	delegate.testQCFactory = function(){
		return qcFactory.test();
	};
	
	// Trainer API
	delegate.getAllBatches = function(){
		return trainerFactory.getAllBatches();
	};
	
	delegate.getCurrentBatch = function(){
		return trainerFactory.getCurrentBatch();
	};
	
	delegate.getBatch = function(id){
		return trainerFactory.getBatch(id);
	};
	
	return delegate;
});