var func = function() {
    var result = [1,2,3,4,5]
        .map(function(num) { return num * 2  })
        .reduce(function(acc, num) { return acc += num + '_'; }, '');
    print(result);
}();