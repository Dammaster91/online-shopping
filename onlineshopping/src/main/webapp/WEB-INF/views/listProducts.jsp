<div class="container">
	<div class="row">
		<!-- Would to display side bar -->
		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>
		<!-- Would to display catual product bar -->

		<div class="col-md-9">
			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home </a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="container-fluid">
						<div class="table-responsive">
							<table id="productListTable"
								class="table table-striped table-borderd">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty. Available</th>
										<th></th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty. Available</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>

</div>
<!-- <div id="myModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      dialog body
      <div class="modal-body">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        Hello world!
      </div>
      dialog buttons
      <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>
    </div>
  </div>
</div> -->

<!-- sometime later, probably inside your on load event callback -->
