var dataTableJesOptions={
    "paging": true,
    "pagingType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
    "pageLength": 10,
    "lengthMenu": [5, 10, 25, 50, 75, 100],
    "language": { //下面是一些汉语翻译
        "search": "搜索：",
        "lengthMenu": "每页显示的条数：_MENU_",
        "zeroRecords": "没有检索到数据",
        "info": "当前显示从 _START_ 到 _END_ 的数据，共 _TOTAL_ 条数据。",
        "infoFiltered": "(筛选自 _MAX_ 条数据)",
        "emptyTable": "没有数据",
        "loadingRecords": "正在加载数据...",
        "paginate": {
            "first": "首页",
            "previous": "前一页",
            "next": "后一页",
            "last": "末页"
        }
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