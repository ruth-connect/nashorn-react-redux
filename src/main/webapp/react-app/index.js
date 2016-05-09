import React from 'react';
import { renderToString } from 'react-dom/server';
import App from './components/App.js';

export function render(path, filmList) : string {
    return renderToString(<App filmList={filmList} />);
}
