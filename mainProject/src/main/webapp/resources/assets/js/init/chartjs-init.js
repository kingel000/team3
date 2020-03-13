( function ( $ ) {
    "use strict";

    //Team chart
    var ctx = document.getElementById( "team-chart" );
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'line',
        data: {
            labels: [ "2012", "2013", "2014", "2015", "2016", "2017", "2018" ],
            type: 'line',
            defaultFontFamily: 'Montserrat',
            datasets: [ {
                data: [ 0, 7, 3, 5, 2, 8, 6 ],
                label: "Expense",
                backgroundColor: 'rgba(0,200,155,.35)',
                borderColor: 'rgba(0,200,155,0.60)',
                borderWidth: 3.5,
                pointStyle: 'circle',
                pointRadius: 5,
                pointBorderColor: 'transparent',
                pointBackgroundColor: 'rgba(0,200,155,0.60)',
                    },
                    {
                data: [ 0, 6, 3, 4, 3, 7, 10 ],
                label: "Profit",
                backgroundColor: 'rgba(0,194,146,.25)',
                borderColor: 'rgba(0,194,146,0.5)',
                borderWidth: 3.5,
                pointStyle: 'circle',
                pointRadius: 5,
                pointBorderColor: 'transparent',
                pointBackgroundColor: 'rgba(0,194,146,0.5)',
                    }, ]
        },
        options: {
            responsive: true,
            tooltips: {
                mode: 'index',
                titleFontSize: 12,
                titleFontColor: '#000',
                bodyFontColor: '#000',
                backgroundColor: '#fff',
                titleFontFamily: 'Montserrat',
                bodyFontFamily: 'Montserrat',
                cornerRadius: 3,
                intersect: false,
            },
            legend: {
                display: false,
                position: 'top',
                labels: {
                    usePointStyle: true,
                    fontFamily: 'Montserrat',
                },


            },
            scales: {
                xAxes: [ {
                    display: true,
                    gridLines: {
                        display: false,
                        drawBorder: false
                    },
                    scaleLabel: {
                        display: false,
                        labelString: 'Month'
                    }
                        } ],
                yAxes: [ {
                    display: true,
                    gridLines: {
                        display: false,
                        drawBorder: false
                    },
                    scaleLabel: {
                        display: true,
                        labelString: 'Value'
                    }
                        } ]
            },
            title: {
                display: false,
            }
        }
    } );


    //Sales chart
    //var monthTotalSales = '${monthTotalSales}';
    var ctx = document.getElementById( "sales-chart" );
    var d = [0,0,0,4,0,0,0,0,0,0,0,0];
    
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'line',
        data: {
            labels: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
            type: 'line',
            defaultFontFamily: 'Montserrat',
            datasets: [ {
                label: "월판매량: ",
                data: [M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12],
                backgroundColor: 'transparent',
                borderColor: 'rgba(220,53,69,0.75)',
                borderWidth: 3,
                pointStyle: 'circle',
                pointRadius: 5,
                pointBorderColor: 'transparent',
                pointBackgroundColor: 'rgba(220,53,69,0.75)',
                    } ]
        },
        options: {
            responsive: true,

            tooltips: {
                mode: 'index',
                titleFontSize: 12,
                titleFontColor: '#000',
                bodyFontColor: '#000',
                backgroundColor: '#fff',
                titleFontFamily: 'Montserrat',
                bodyFontFamily: 'Montserrat',
                cornerRadius: 3,
                intersect: false,
            },
            legend: {
                display: false,
                labels: {
                    usePointStyle: true,
                    fontFamily: 'Montserrat',
                },
            },
            scales: {
                xAxes: [ {
                    display: true,
                    gridLines: {
                        display: false,
                        drawBorder: false
                    },
                    scaleLabel: {
                        display: false,
                        labelString: 'Month'
                    }
                        } ],
                yAxes: [ {
                    display: true,
                    gridLines: {
                        display: false,
                        drawBorder: false
                    },
                    scaleLabel: {
                        display: true,
                        labelString: 'Point'
                    }
                        } ]
            },
            title: {
                display: false,
                text: 'Normal Legend'
            }
        }
    } );







    //line chart
    var ctx = document.getElementById( "lineChart" );
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'line',
        data: {
            labels: [ "January", "February", "March", "April", "May", "June", "July" ],
            datasets: [
                {
                    label: "My First dataset",
                    borderColor: "rgba(0,0,0,.09)",
                    borderWidth: "1",
                    backgroundColor: "rgba(0,0,0,.07)",
                    data: [ 20, 47, 35, 43, 65, 45, 35 ]
                            },
                {
                    label: "My Second dataset",
                    borderColor: "rgba(0, 194, 146, 0.9)",
                    borderWidth: "1",
                    backgroundColor: "rgba(0, 194, 146, 0.5)",
                    pointHighlightStroke: "rgba(26,179,148,1)",
                    data: [ 16, 32, 18, 27, 42, 33, 44 ]
                            }
                        ]
        },
        options: {
            responsive: true,
            tooltips: {
                mode: 'index',
                intersect: false
            },
            hover: {
                mode: 'nearest',
                intersect: true
            }

        }
    } );


    //bar chart
    var ctx = document.getElementById( "barChart" );
    //    ctx.height = 200;
    var myChart = new Chart( ctx, {
        type: 'bar',
        data: {
            labels: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul" ],
            datasets: [
                {
                    label: "My First dataset",
                    data: [ 65, 59, 80, 81, 56, 55, 45 ],
                    borderColor: "rgba(0, 194, 146, 0.9)",
                    borderWidth: "0",
                    backgroundColor: "rgba(0, 194, 146, 0.5)"
                            },
                {
                    label: "My Second dataset",
                    data: [ 28, 48, 40, 19, 86, 27, 76 ],
                    borderColor: "rgba(0,0,0,0.09)",
                    borderWidth: "0",
                    backgroundColor: "rgba(0,0,0,0.07)"
                            }
                        ]
        },
        options: {
            scales: {
                yAxes: [ {
                    ticks: {
                        beginAtZero: true
                    }
                                } ]
            }
        }
    } );

    //radar chart
    var ctx = document.getElementById( "radarChart" );
    ctx.height = 160;
    var myChart = new Chart( ctx, {
        type: 'radar',
        data: {
            labels: [ [ "Eating", "Dinner" ], [ "Drinking", "Water" ], "Sleeping", [ "Designing", "Graphics" ], "Coding", "Cycling", "Running" ],
            datasets: [
                {
                    label: "My First dataset",
                    data: [ 65, 70, 66, 45, 5, 55, 40 ],
                    borderColor: "rgba(0, 194, 146, 0.6)",
                    borderWidth: "1",
                    backgroundColor: "rgba(0, 194, 146, 0.4)"
                            },
                {
                    label: "My Second dataset",
                    data: [ 28, 5, 55, 19, 63, 27, 68 ],
                    borderColor: "rgba(0, 194, 146, 0.7",
                    borderWidth: "1",
                    backgroundColor: "rgba(0, 194, 146, 0.5)"
                            }
                        ]
        },
        options: {
            legend: {
                position: 'top'
            },
            scale: {
                ticks: {
                    beginAtZero: true
                }
            }
        }
    });


    //pie chart

    var ctx = document.getElementById( "pieChart" );
    ctx.height = 300;
    var myChart = new Chart( ctx, {
        type: 'pie',
        data: {
            datasets: [ {
                data: [ nomalMemberCount, expertMemberCount ],
                backgroundColor: [
                                    "rgba(0, 194, 146,0.9)",
                                    "rgba(0, 194, 146,0.7)"

                                ],
                hoverBackgroundColor: [
                                    "rgba(0, 194, 146,0.5)",
                                    "rgba(0,0,0,0.07)"
                                ]

                            } ],
            labels: [
                            "일반 회원수",
                            "전문가 회원수"
                        ]
        },
        options: {
            responsive: true
        }
    } );

    //doughut chart
    var ctx = document.getElementById( "doughutChart" );
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'doughnut',
        data: {
            datasets: [ {
                data: [ 35, 40, 20, 5 ],
                backgroundColor: [
                                    "rgba(0, 194, 146,0.9)",
                                    "rgba(0, 194, 146,0.7)",
                                    "rgba(0, 194, 146,0.5)",
                                    "rgba(0,0,0,0.07)"
                                ],
                hoverBackgroundColor: [
                                    "rgba(0, 194, 146,0.9)",
                                    "rgba(0, 194, 146,0.7)",
                                    "rgba(0, 194, 146,0.5)",
                                    "rgba(0,0,0,0.07)"
                                ]

                            } ],
            labels: [
                            "green",
                            "green",
                            "green",
                            "green"
                        ]
        },
        options: {
            responsive: true
        }
    } );

    //polar chart
    var ctx = document.getElementById( "polarChart" );
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'polarArea',
        data: {
            datasets: [ {
                data: [ 15, 18, 10, 7, 19],
                backgroundColor: [
                                    "rgba(0, 194, 146,0.9)",
                                    "rgba(0, 194, 146,0.8)",
                                    "rgba(0, 194, 146,0.7)",
                                    "rgba(0,0,0,0.2)",
                                    "rgba(0, 194, 146,0.5)"
                                ]

                            } ],
            labels: [
                            "green",
                            "green",
                            "green",
                            "green"
                        ]
        },
        options: {
            responsive: true
        }
    } );

    // single bar chart
    var ctx = document.getElementById( "singelBarChart" );
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'bar',
        data: {
            labels: [ "웹개발", "모바일앱웹", "게임", "응용프로그래밍", "기타" ],
            datasets: [
                {
                    label: "총 판매량",
                    data: [ category_totalSales1, category_totalSales2, category_totalSales3, category_totalSales4, category_totalSales5 ],
                    borderColor: "rgba(0, 194, 146, 0.9)",
                    borderWidth: "0",
                    backgroundColor: "rgba(0, 194, 146, 0.5)"
                            }
                        ]
        },
        options: {
            scales: {
                yAxes: [ {
                    ticks: {
                        beginAtZero: true
                    }
                                } ]
            }
        }
    } );




} )( jQuery );