var exec = require('cordova/exec');

var failed = function(msg) {
	alert('Failed: ' + msg);
}

document.body.onclick = function() {
	exec(null, failed, 'Demo', 'keyClick', []);
}
