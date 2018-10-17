/*
 * Parse the data and create a graph with the data.
 */
function parseData(createGraph) {
	Papa.parse("../data/totalreplies.csv", {
		download: true,
		complete: function(results) {
			createGraph(results.data);
		}
	});
}

function createGraph(data) {
	var words = [];
	var frequency = ["Frequency"];
	
	for (var i = 1; i < 26; i++) {
		words.push(data[i][0]);
		frequency.push(data[i][1]);
	}

	 console.log(words);
	 console.log(frequency);

	var chart = c3.generate({
		bindto: '#chart',
	    data: {
	        columns: [
	        	frequency
	        ]
	    },
	    axis: {
	        x: {
	            type: 'category',
	            categories: words,
	            tick: {
	            	multiline: false,
                	culling: {
                    	max: 15
                	}
            	}
	        }
	    },
	    zoom: {
        	enabled: true
    	},
	    legend: {
	        position: 'right'
	    }
	});
}

parseData(createGraph);