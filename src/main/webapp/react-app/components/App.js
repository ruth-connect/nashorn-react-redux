import React from 'react';

export default ({ filmList }) => (
    <div>
        <h1>HELLO FROM REACT</h1>
        <FilmList filmList={filmList} />
    </div>
);

const FilmList = ({ filmList }) => <div>{filmList.map((film, i) => <Film key={i} film={film} />)}</div>;
const Film = ({ film }) => <p>{film.title} [{film.year}]</p>;