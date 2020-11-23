export function loadTopicsForMainTopic(id: string) {
    return [{
        title: "Tư vấn cấu hình",
        threads: 12,
        messages: 158
    },{
        title: "AMD",
        threads: 10,
        messages: 10900
    },{
        title: "GPU & Màn hình",
        threads: 160,
        messages: 500000
    }];
}

export function loadMainTopicsForApp() {
    return [{
        id: "computer-main-topic",
        title: "Máy tính"
    },{
        id: "software-games",
        title: "Phần mềm && Games"
    },{
        id: "technology-produts",
        title: "Sản phẩm công nghệ"
    }]
}
