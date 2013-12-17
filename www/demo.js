var exec = require('cordova/exec');

var failed = function(msg) {
	alert('Failed: ' + msg);
};

document.body.onclick = function() {
	exec(function() {
		alert('Success: Demo.keyClick');

		if (confirm('call: cordova.plugins.demo.DemoActivity')) {
			exec(function(msg) {
				alert('Success: Demo.callActivity.\n' + msg);
			}, failed, 'Demo', 'callActivity', [ 'cordova.plugins.demo.DemoActivity' ]);
		}
	}, failed, 'Demo', 'keyClick', []);
};
