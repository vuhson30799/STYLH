import React from "react";

export class MyFooter extends React.Component<any, any> {
    render() {
        return (
            <div className={"MyFooter"}>
                <div style={{textAlign: "center",fontSize:"0.75rem"}}>
                    Chịu trách nhiệm nội dung: Bạch Thành Trung © 2000-2020 Công ty TNHH Thật Vi Diệu<br/>
                    ĐC tầng 4, số 6-8 đường D2, phường 25, Bình Thạnh, Hồ Chí Minh, Việt Nam - SĐT 0983757213 - MST
                    0313906593<br/>
                    Giấy phép thiết lập MXH số 334/GP-BTTTT, Ký ngày: 19/08/2019
                </div>
            </div>
        );
    }
}
