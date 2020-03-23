import { Button } from 'antd';
import React from 'react';
const Login = () => {
    return (
        <div>
            <h2>这是登录窗口</h2>
            <Button type="primary">注册</Button>
            <Button>登录</Button>
            <br/>
            <Button type="dashed">Dashed</Button>
            <Button type="danger">Danger</Button>
        </div>
    );
};
export default Login;