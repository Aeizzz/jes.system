var dataTableJesOptions={
    "scrollY": "400px",
    "scrollCollapse": true,
    "searching": false,
    "ordering": false,
    "paging": true,
    // "pagingType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
    "pageLength": 5,
    "lengthMenu": [5, 10, 25, 50, 75, 100],
    "language": {
        "processing": "处理中...",
        "lengthMenu": "显示 _MENU_ 项结果",
        "zeroRecords": "没有匹配结果",
        "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
        "infoFiltered": "(由 _MAX_ 项结果过滤)",
        "infoPostFix": "",
        "search": "搜索:",
        "searchPlaceholder": "搜索...",
        "url": "",
        "emptyTable": "表中数据为空",
        "loadingRecords": "载入中...",
        "infoThousands": ",",
        "paginate": {
            "first": "首页",
            "previous": "上页",
            "next": "下页",
            "last": "末页"
        },
        "aria": {
            "paginate": {
                "first": "首页",
                "previous": "上页",
                "next": "下页",
                "last": "末页"
            },
            "sortAscending": "以升序排列此列",
            "sortDescending": "以降序排列此列"
        },
        "thousands": "."
    },
    "processing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
    "serverSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。
    "ajax": {},
    "drawCallback": function () {
        this.api().column(0).nodes().each(function (cell, i) {//index
            cell.innerHTML = i + 1;
        });
    }
}