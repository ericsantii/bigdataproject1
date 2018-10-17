/*
 * Parse the data and create a graph with the data.
 */
function parseData(createGraph) {
	Papa.parse("../data/totaltweetsbyuser.csv", {
		download: true,
		complete: function(results) {
			createGraph(results.data);
		}
	});
}

function createGraph(data) {
	var words = [];
	var frequency = [];
	
	for (var i = 0; i < data.length; i++) {
		words.push(data[i][0]);
		frequency.push(data[i][1]);
	}

	 console.log(words);
	 console.log(frequency);

     var chart = c3.generate({

        data: {
            columns: [
               frequency
            ],
            type : 'scatter',
            onclick: function (d, i) { console.log("onclick", d, i); },
            onmouseover: function (d, i) { console.log("onmouseover", d, i); },
            onmouseout: function (d, i) { console.log("onmouseout", d, i); }
        },
        axis: {
            x: {
                type:'category',
                categories:words,
                tick: {
                    fit: false
                }
            },
            
        }
    });
}

parseData(createGraph);