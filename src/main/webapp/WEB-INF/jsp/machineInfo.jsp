<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="common/header.jspf" %>

<section id="main-content">
    <c:url var="viewMachineInfoUrl" value="/viewMachineInfo"/>
    <c:url var="stationaryBikeUrl" value="https://www.youtube.com/watch?v=0xyrFXI4rHI"/>
    <c:url var="treadmillUrl" value="https://www.youtube.com/watch?v=FDavXHUMpGA"/>
    <c:url var="rowMachineUrl" value="https://www.youtube.com/watch?v=X7fzHnnohvM"/>
    <c:url var="ellipticalUrl" value="https://www.youtube.com/watch?v=9r7SsbzKh9I"/>
    <c:url var="stairMasterUrl" value="https://www.youtube.com/watch?v=fhj7dHcpD2Q"/>
    <c:url var="legPressUrl" value="https://www.youtube.com/watch?v=xgQAn-b4ems"/>
    <c:url var="chestPressUrl" value="https://www.youtube.com/watch?v=bRgJ9mGQvdk"/>
    <c:url var="smithUrl" value="https://www.youtube.com/watch?v=tVR6CIc5IQw"/>
    <c:url var="legCurlUrl" value="https://www.youtube.com/watch?v=QjNFk4F5dAs"/>
    <c:url var="benchPressUrl" value="https://www.youtube.com/watch?v=rxD321l2svE&t=125s"/>

    <h2>Machine Guide</h2>
<%--First Row--%>
    <div class="row">
        <div class="col-sm-6">
            <div class="card" style="width: 31rem;">
                <span class="border border-secondary"></span>
                <img src="${pageContext.request.contextPath}/img/stationarybike.png" class="card-img-top" alt="stationary bike">
                <div class="card-body">
                    <h5 class="card-title">Stationary Bike</h5>
                    <p class="card-text">Using a stationary bike can help you with leg endurance and healthy joints.
                        Click the button below to learn more.</p>
                    <a href="${stationaryBikeUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card" style="width: 31rem;">

                <img src="${pageContext.request.contextPath}/img/treadmill.png" class="card-img-top" alt="treadmill">
                <div class="card-body">
                    <h5 class="card-title">Treadmill</h5>
                    <p class="card-text">A treadmill can help with boosting a healthy heart, increase your stamina, and
                        endurance. Click the button below to learn more</p>
                    <a href="${treadmillUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
    </div>
<%--Second Row--%>
    <div class="row">
        <div class="col-sm-6">
            <div class="card" style="width: 31rem;">
                <img src="${pageContext.request.contextPath}/img/rowingmachine.png" class="card-img-top" alt="rowing machine">
                <div class="card-body">
                    <h5 class="card-title">Rowing Machine</h5>
                    <p class="card-text">The rowing machine can improve stamina and overall fitness and strength,
                        including strengthening the heart. It can also boost the immune system. Click the button below
                        to learn more.</p>
                    <a href="${rowMachineUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card" style="width: 31rem;">
                <img src="${pageContext.request.contextPath}/img/eliptical.png" class="card-img-top" alt="elliptical">
                <div class="card-body">
                    <h5 class="card-title">Elliptical</h5>
                    <p class="card-text">A elliptical can help burn a lot of calories, puts less stress on your joints,
                        burns body fat, targets specific leg muscles and improves balance. Click the button below to
                        learn more</p>
                    <a href="${treadmillUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
    </div>
<%--Third Row--%>
        <div class="row">
            <div class="col-sm-6">
                <div class="card" style="width: 31rem;">
                    <img src="${pageContext.request.contextPath}/img/rowingmachine.png" class="card-img-top" alt="rowing machine">
                    <div class="card-body">
                        <h5 class="card-title">Rowing Machine</h5>
                        <p class="card-text">The rowing machine can improve stamina and overall fitness and strength,
                            including strengthening the heart. It can also boost the immune system. Click the button below
                            to learn more.</p>
                        <a href="${rowMachineUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card" style="width: 31rem;">
                    <img src="${pageContext.request.contextPath}/img/eliptical.png" class="card-img-top" alt="elliptical">
                    <div class="card-body">
                        <h5 class="card-title">Elliptical</h5>
                        <p class="card-text">A elliptical can help burn a lot of calories, puts less stress on your joints,
                            burns body fat, targets specific leg muscles and improves balance. Click the button below to
                            learn more</p>
                        <a href="${treadmillUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
        </div>
<%--Fourth Row--%>
        <div class="row">
            <div class="col-sm-6">
                <div class="card" style="width: 31rem;">
                    <img src="${pageContext.request.contextPath}/img/rowingmachine.png" class="card-img-top" alt="rowing machine">
                    <div class="card-body">
                        <h5 class="card-title">Rowing Machine</h5>
                        <p class="card-text">The rowing machine can improve stamina and overall fitness and strength,
                            including strengthening the heart. It can also boost the immune system. Click the button below
                            to learn more.</p>
                        <a href="${rowMachineUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card" style="width: 31rem;">
                    <img src="${pageContext.request.contextPath}/img/eliptical.png" class="card-img-top" alt="elliptical">
                    <div class="card-body">
                        <h5 class="card-title">Elliptical</h5>
                        <p class="card-text">A elliptical can help burn a lot of calories, puts less stress on your joints,
                            burns body fat, targets specific leg muscles and improves balance. Click the button below to
                            learn more</p>
                        <a href="${treadmillUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6">
                <div class="card" style="width: 31rem;">
                    <img src="${pageContext.request.contextPath}/img/rowingmachine.png" class="card-img-top" alt="rowing machine">
                    <div class="card-body">
                        <h5 class="card-title">Rowing Machine</h5>
                        <p class="card-text">The rowing machine can improve stamina and overall fitness and strength,
                            including strengthening the heart. It can also boost the immune system. Click the button below
                            to learn more.</p>
                        <a href="${rowMachineUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card" style="width: 31rem;">
                    <img src="${pageContext.request.contextPath}/img/eliptical.png" class="card-img-top" alt="elliptical">
                    <div class="card-body">
                        <h5 class="card-title">Elliptical</h5>
                        <p class="card-text">A elliptical can help burn a lot of calories, puts less stress on your joints,
                            burns body fat, targets specific leg muscles and improves balance. Click the button below to
                            learn more</p>
                        <a href="${treadmillUrl}" target="_blank" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
        </div>
<%@ include file="common/footer.jspf" %>