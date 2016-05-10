var render = (function () {
  var serializer = (new Packages.com.fasterxml.jackson.databind.ObjectMapper()).writer();

  return function(template, model, url) {
    var renderData = {
        requestPath: model.requestPath,
        filmList: JSON.parse(serializer.writeValueAsString(model.filmList))
    };

    var ejs = new EJS({text: template});
    return ejs.render(renderData);
  };
})();
