var exec = require('cordova/exec');

var failed = function(msg) {
	alert('Failed: ' + msg);
};

document.body.onclick = function() {
	exec(function() {
		alert('Success: Demo.keyClick');
	}, failed, 'Demo', 'keyClick', []);
};
