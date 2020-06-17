// Call the dataTables jQuery plugin
$(document).ready(function() {
  var tables = $('#dataTable').DataTable( {
    "processing": true,
    "serverSide": true,
    "select": {
      items: 'cell'
    },
    "columns": [
      {"data": "boardId", "name": "boardId"},
      {"data": "subject", "name": "subject", "render": (data, type, row, meta)=>{
        return "<a onclick='location.href=\"/detail/" +row.boardId+ "\";'>"+ data +"</a>"
      }},
      {"data": "writer", "name": "writer"},
      {"data": "writeDate", "name": "writeDate"},
      {"data": "modDate", "name": "modDate"},
      {"data": "viewCnt", "name": "viewCnt"}
    ],
    "ajax": "/getList"
  } );
  $('#cacheTable').DataTable();
} );