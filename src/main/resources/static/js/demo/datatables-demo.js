// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable( {
    "processing": true,
    "serverSide": true,
    "columns": [
      {"data": "boardId", "name": "boardId"},
      {"data": "subject", "name": "subject"},
      {"data": "writer", "name": "writer"},
      {"data": "writeDate", "name": "writeDate"},
      {"data": "modDate", "name": "modDate"},
      {"data": "viewCnt", "name": "viewCnt"}
    ],
    "ajax": "/getList"
  } );
} );