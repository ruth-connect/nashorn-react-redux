var path = require('path');
var webpack = require('webpack');

module.exports = {
    context: __dirname,
    entry: './index.js',
    output: {
        path: path.resolve(__dirname, '../../resources/static/js'),
        filename: 'bundle.js',
        library: 'ReactApp'
    },
    module: {
        loaders: [
            {
                test: /.js?$/,
                loader: 'babel-loader',
                query: {stage: 0},
                exclude: /node_modules/
            }
        ]
    }
};
