import React from 'react';
import MainMenu from './MainMenu';
import Nav from './Nav';

function MainLayout({children}) {
    return (
        <div>
            <Nav />
            <div className='my-10'>
            {children}
            </div>
            <MainMenu />
        </div>
    );
}

export default MainLayout;