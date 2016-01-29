
<<<<<<< HEAD

<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<div id="divCentro">
    <div id="container">
        <input id="tab-1" type="radio" name="tab-group" checked="checked" /> <label
            for="tab-1">Pol&iacute;ticos</label> <input id="tab-2" type="radio"
            name="tab-group" /> <label for="tab-2">Pa&iacute;ses</label>
        <div id="content">
            <div id="content-1">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre pol&iacute;tico</th>
                            <th colspan="7">Stats</th>
                        </tr>
                        <tr>
                            <th></th>

                            <th>Honestidad</th>
                            <th>Carisma</th>
                            <th>Elocuencia</th>
                            <th>Popularidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${politicos}" var="b">
                            <tr>
                                <td>${b.nombre}</td>
                                <td><progress value="${b.honestidad}" max="100">${b.honestidad}%</progress></td>
                                <td><progress value="${b.carisma}" max="100">${b.carisma}%</progress></td>
                                <td><progress value="${b.elocuencia}" max="100">${b.elocuencia}%</progress></td>
                                <td><progress value="${b.popularidad}" max="100">${b.popularidad}%</progress></td>
                            <tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div id="content-2">

                <table>
                    <thead>
                        <tr>
                            <th>Pa&iacute;s</th>
                            <th colspan="5">Stats</th>
                        </tr>
                        <tr>
                            <th></th>
                            <th>PIB</th>
                            <th>Apoyo Popular</th>
                            <th>Energ&iacute;a</th>
                            <th>Poblaci&oacute;n</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${paises}" var="r">
                        <tr>
                            <td>${r.nombre}</td>
                            <td><progress value="${r.recursos.PIB}" max="100">${r.recursos.PIB}%</progress></td>
                            <td><progress value="${r.recursos.APOYO_POPULAR }" max="100">${r.recursos.APOYO_POPULAR }%</progress></td>
                            <td><progress value="${r.recursos.ENERGIA}" max="100">${r.recursos.ENERGIA }%</progress></td>
                            <td><progress value="${r.recursos.POBLACION }" max="100">${r.recursos.POBLACION }%</progress></td>
                        <tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
=======
<%@ include file="../fragments/header.jsp"%>
<%@ include file="../fragments/menu.jsp"%>
<div id="divCentro">
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked" /> <label
			for="tab-1">Pol&iacute;ticos</label> <input id="tab-2" type="radio"
			name="tab-group" /> <label for="tab-2">Pa&iacute;ses</label>
		<div id="content">
			<div id="content-1">
				<table>
					<thead>
						<tr>
							<th>Nombre pol&iacute;tico</th>
							<th colspan="7">Stats</th>
						</tr>
						<tr>
							<th></th>

							<th>Honestidad</th>
							<th>Carisma</th>
							<th>Elocuencia</th>
							<th>Popularidad</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${politicos}" var="b">
							<tr>
								<td>${b.nombre}</td>
								<td><progress value="${b.honestidad}" max="100">${b.honestidad}%</progress></td>
								<td><progress value="${b.carisma}" max="100">${b.carisma}%</progress></td>
								<td><progress value="${b.elocuencia}" max="100">${b.elocuencia}%</progress></td>
								<td><progress value="${b.popularidad}" max="100">${b.popularidad}%</progress></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="content-2">

				<table>
					<thead>
						<tr>
							<th>Pa&iacute;s</th>
							<th colspan="5">Stats</th>
						</tr>
						<tr>
							<th></th>
							<th>PIB</th>
							<th>Apoyo Popular</th>
							<th>Energ&iacute;a</th>
							<th>Poblaci&oacute;n</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${paises}" var="r">
						<tr>
							<td>${r.nombre}</td>
							<td><progress value="${r.recursos.PIB}" max="100">${r.recursos.PIB}%</progress></td>
							<td><progress value="${r.recursos.APOYO_POPULAR }" max="100">${r.recursos.APOYO_POPULAR }%</progress></td>
							<td><progress value="${r.recursos.ENERGIA}" max="100">${r.recursos.ENERGIA }%</progress></td>
							<td><progress value="${r.recursos.POBLACION }" max="100">${r.recursos.POBLACION }%</progress></td>
						<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
>>>>>>> refs/remotes/origin/contratar-politico
</div>


<%@ include file="../fragments/footer.jsp"%>
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/contratar-politico
