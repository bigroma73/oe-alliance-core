require vuplus-blindscan-utils.inc

do_install() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/tda1002x" "${D}/${bindir}"
}

SRC_URI[md5sum] = "03d33d3b0f529bb543a23dade3038d45"
SRC_URI[sha256sum] = "66b49229cd697f8574620f02026ef25e747a16218f199b7567543188c700a7b8"