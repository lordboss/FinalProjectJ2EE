use j2ee;


SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(40) NOT NULL,
  `Pass` varchar(500) NOT NULL,
  `TrangThai` int(11) NOT NULL,
  `Ho` varchar(20) NOT NULL,
  `Dem` varchar(40) DEFAULT NULL,
  `Ten` varchar(20) NOT NULL,
  `Email` varchar(80) NOT NULL,
  `Xoa` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'user01', 'user01', '1', 'Nguyễn', 'Văn', 'A', 'nguyen.van.a@gmail.com', '0');
INSERT INTO `account` VALUES ('2', 'user02', 'user02', '1', 'Nguyễn', 'Văn', 'B', 'nguyen.van.b@gmail.com', '0');
INSERT INTO `account` VALUES ('3', 'user03', 'user03', '1', 'Nguyễn', 'Văn', 'C', 'nguyen.van.c@gmail.com', '0');
INSERT INTO `account` VALUES ('4', 'user04', 'user04', '1', 'Nguyễn', 'Văn', 'D', 'nguyen.van.d@gmail.com', '0');
INSERT INTO `account` VALUES ('5', 'user05', 'user05', '1', 'Nguyễn', 'Văn', 'E', 'nguyen.van.e@gmail.com', '0');
INSERT INTO `account` VALUES ('6', 'user06', 'user06', '1', 'Nguyễn', 'Văn', 'F', 'nguyen.van.f@gmail.com', '0');
INSERT INTO `account` VALUES ('7', 'user07', 'user07', '1', 'Nguyễn', 'Văn', 'G', 'nguyen.van.g@gmail.com', '0');
INSERT INTO `account` VALUES ('8', 'nv01', 'nv01', '1', 'Trần', 'Văn', 'A', 'tran.van.a@gmail.com', '0');
INSERT INTO `account` VALUES ('9', 'nv02', 'nv02', '1', 'Trần', 'Văn', 'B', 'tran.van.b@gmail.com', '0');
INSERT INTO `account` VALUES ('10', 'nv03', 'nv03', '1', 'Trần', 'Văn', 'C', 'tran.van.c@gmail.com', '0');
INSERT INTO `account` VALUES ('11', 'nvql01', 'nvql01', '1', 'Phan', 'Văn', 'A', 'phan.van.a@gmail.com', '0');
INSERT INTO `account` VALUES ('12', 'nvql02', 'nvql02', '1', 'Phan', 'Văn', 'B', 'phan.van.b@gmail.com', '0');
INSERT INTO `account` VALUES ('13', 'nvql03', 'nvql03', '1', 'Phan', 'Văn', 'C', 'phan.van.c@gmail.com', '0');
INSERT INTO `account` VALUES ('14', 'nvqt01', 'nvqt01', '1', 'Bùi', 'Văn', 'A', 'bui.van.a@gmail.com', '0');
INSERT INTO `account` VALUES ('15', 'nvqt02', 'nvqt02', '1', 'Bùi', 'Văn', 'B', 'bui.van.b@gmail.com', '0');
INSERT INTO `account` VALUES ('16', 'nvqt03', 'nvqt03', '1', 'Bùi', 'Văn', 'C', 'bui.van.c@gmail.com', '0');

-- ----------------------------
-- Table structure for `ct_donhang`
-- ----------------------------
DROP TABLE IF EXISTS `ct_donhang`;
CREATE TABLE `ct_donhang` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DonHang` int(11) DEFAULT NULL,
  `ID_SanPham` int(11) DEFAULT NULL,
  `SoLuong` int(11) NOT NULL,
  `Xoa` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `ID_DonHang` (`ID_DonHang`),
  KEY `ID_SanPham` (`ID_SanPham`),
  CONSTRAINT `ct_donhang_ibfk_1` FOREIGN KEY (`ID_DonHang`) REFERENCES `donhang` (`ID`),
  CONSTRAINT `ct_donhang_ibfk_2` FOREIGN KEY (`ID_SanPham`) REFERENCES `sanpham` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ct_donhang
-- ----------------------------

-- ----------------------------
-- Table structure for `ct_hinhanh`
-- ----------------------------
DROP TABLE IF EXISTS `ct_hinhanh`;
CREATE TABLE `ct_hinhanh` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SanPham` int(11) DEFAULT NULL,
  `HinhAnh` varchar(50) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_SanPham` (`ID_SanPham`),
  CONSTRAINT `ct_hinhanh_ibfk_1` FOREIGN KEY (`ID_SanPham`) REFERENCES `sanpham` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ct_hinhanh
-- ----------------------------
INSERT INTO `ct_hinhanh` VALUES ('1', '1', 'Nokia_N900_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('2', '1', 'Nokia_N900_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('3', '1', 'Nokia_N900_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('4', '1', 'Nokia_N900_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('5', '1', 'Nokia_N900_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('6', '1', 'Nokia_N900_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('7', '2', '9_the_nho_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('8', '3', '9_the_nho_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('9', '4', '9_the_nho_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('10', '5', '9_the_nho_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('11', '6', '9_the_nho_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('12', '7', '9_the_nho_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('13', '8', '9_the_nho_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('14', '9', '9_the_nho_8.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('15', '10', '9_the_nho_9.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('16', '11', '9_the_nho_10.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('17', '12', '9_the_nho_11.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('18', '13', '9_the_nho_12.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('19', '14', '1_baoda_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('20', '15', '1_baoda_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('21', '16', '1_baoda_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('22', '17', '1_baoda_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('23', '18', '1_baoda_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('24', '19', '1_baoda_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('25', '20', '1_baoda_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('26', '21', '1_baoda_8.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('27', '22', '1_baoda_9.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('28', '23', '2_vomay_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('29', '24', '2_vomay_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('30', '25', '2_vomay_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('31', '26', '3_pin_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('32', '27', '3_pin_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('33', '28', '3_pin_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('34', '29', '3_pin_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('35', '30', '3_pin_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('36', '31', '3_pin_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('37', '32', '3_pin_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('38', '33', '3_pin_8.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('39', '34', '3_pin_9.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('40', '35', '3_pin_10.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('41', '36', '3_pin_11.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('42', '37', '3_pin_12.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('43', '38', '3_pin_13.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('44', '39', '3_pin_14.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('45', '40', '3_pin_15.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('46', '41', '3_pin_16.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('47', '42', '3_pin_17.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('48', '43', '3_pin_18.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('49', '44', '3_pin_19.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('50', '45', '3_pin_20.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('51', '46', '3_pin_21.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('52', '47', '3_pin_22.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('53', '48', '3_pin_23.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('54', '49', '3_pin_24.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('55', '50', '3_pin_25.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('56', '51', '3_pin_26.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('57', '52', '3_pin_27.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('58', '53', '3_pin_28.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('59', '54', '3_pin_29.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('60', '55', '4_sac_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('61', '56', '4_sac_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('62', '57', '4_sac_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('63', '58', '4_sac_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('64', '59', '4_sac_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('65', '60', '4_sac_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('66', '61', '4_sac_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('67', '62', '4_sac_8.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('68', '63', '4_sac_9.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('69', '64', '4_sac_10.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('70', '65', '4_sac_11.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('71', '66', '4_sac_12.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('72', '67', '4_sac_13.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('73', '68', '4_sac_14.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('74', '69', '5_tt_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('75', '70', '5_tt_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('76', '71', '5_tt_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('77', '72', '5_tt_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('78', '73', '6_cap_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('79', '74', '6_cap_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('80', '75', '6_cap_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('81', '76', '6_cap_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('82', '77', '6_cap_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('83', '78', '6_cap_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('84', '79', '6_cap_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('85', '80', '7_tn_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('86', '81', '7_tn_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('87', '82', '7_tn_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('88', '83', '7_tn_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('89', '84', '7_tn_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('90', '85', '7_tn_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('91', '86', '7_tn_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('92', '87', '7_tn_8.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('93', '88', '7_tn_9.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('94', '89', '7_tn_10.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('95', '90', '7_tn_11.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('96', '91', '7_tn_12.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('97', '92', '7_tn_13.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('98', '93', '7_tn_14.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('99', '94', '7_tn_15.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('100', '95', '7_tn_16.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('101', '96', '7_tn_17.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('102', '97', '7_tn_18.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('103', '98', '7_tn_19.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('104', '99', '7_tn_20.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('105', '100', '7_tn_21.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('106', '101', '7_tn_22.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('107', '102', '7_tn_23.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('108', '103', '7_tn_24.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('109', '104', '7_tn_25.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('110', '105', '7_tn_26.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('111', '106', '7_tn_27.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('112', '107', '7_tn_28.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('113', '108', '8_loa_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('114', '109', '8_loa_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('115', '110', '8_loa_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('116', '111', '8_loa_4.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('117', '112', '8_loa_5.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('118', '113', '8_loa_6.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('119', '114', '8_loa_7.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('120', '115', '8_loa_8.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('121', '116', '10_khac_1.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('122', '117', '10_khac_2.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('123', '118', '10_khac_3.jpg', '0');
INSERT INTO `ct_hinhanh` VALUES ('124', '119', '10_khac_4.jpg', '0');

-- ----------------------------
-- Table structure for `ct_phieunhapdienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `ct_phieunhapdienthoai`;
CREATE TABLE `ct_phieunhapdienthoai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PhieuNhapDienThoai` int(11) DEFAULT NULL,
  `ID_DienThoai` int(11) DEFAULT NULL,
  `SoLuong` int(11) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PhieuNhapDienThoai` (`ID_PhieuNhapDienThoai`),
  KEY `ID_DienThoai` (`ID_DienThoai`),
  CONSTRAINT `ct_phieunhapdienthoai_ibfk_1` FOREIGN KEY (`ID_PhieuNhapDienThoai`) REFERENCES `phieunhapdienthoai` (`ID`),
  CONSTRAINT `ct_phieunhapdienthoai_ibfk_2` FOREIGN KEY (`ID_DienThoai`) REFERENCES `dienthoai` (`ID_SanPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ct_phieunhapdienthoai
-- ----------------------------

-- ----------------------------
-- Table structure for `ct_phieunhapphukien`
-- ----------------------------
DROP TABLE IF EXISTS `ct_phieunhapphukien`;
CREATE TABLE `ct_phieunhapphukien` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PhieuNhapPhuKien` int(11) DEFAULT NULL,
  `ID_PhuKien` int(11) DEFAULT NULL,
  `SoLuong` int(11) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PhieuNhapPhuKien` (`ID_PhieuNhapPhuKien`),
  KEY `ID_PhuKien` (`ID_PhuKien`),
  CONSTRAINT `ct_phieunhapphukien_ibfk_1` FOREIGN KEY (`ID_PhieuNhapPhuKien`) REFERENCES `phieunhapphukien` (`ID`),
  CONSTRAINT `ct_phieunhapphukien_ibfk_2` FOREIGN KEY (`ID_PhuKien`) REFERENCES `phukien` (`ID_SanPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ct_phieunhapphukien
-- ----------------------------

-- ----------------------------
-- Table structure for `ct_tinkhuyenmaidienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `ct_tinkhuyenmaidienthoai`;
CREATE TABLE `ct_tinkhuyenmaidienthoai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TinKhuyenMaiDienThoai` int(11) DEFAULT NULL,
  `ID_DienThoai` int(11) DEFAULT NULL,
  `MucGiam` double NOT NULL,
  `ChiTiet` varchar(200) DEFAULT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_TinKhuyenMaiDienThoai` (`ID_TinKhuyenMaiDienThoai`),
  KEY `ID_DienThoai` (`ID_DienThoai`),
  CONSTRAINT `ct_tinkhuyenmaidienthoai_ibfk_1` FOREIGN KEY (`ID_TinKhuyenMaiDienThoai`) REFERENCES `tinkhuyenmaidienthoai` (`ID`),
  CONSTRAINT `ct_tinkhuyenmaidienthoai_ibfk_2` FOREIGN KEY (`ID_DienThoai`) REFERENCES `dienthoai` (`ID_SanPham`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ct_tinkhuyenmaidienthoai
-- ----------------------------
INSERT INTO `ct_tinkhuyenmaidienthoai` VALUES ('1', '1', '1', '1000000', 'Giảm đến 1 triệu cho Nokia N900', '0');

-- ----------------------------
-- Table structure for `dienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `dienthoai`;
CREATE TABLE `dienthoai` (
  `ID_SanPham` int(11) NOT NULL,
  `ID_HangDienThoai` int(11) DEFAULT NULL,
  `NgheNhac` varchar(25) DEFAULT NULL,
  `XemPhim` varchar(25) DEFAULT NULL,
  `FMRadio` tinyint(1) DEFAULT NULL,
  `XemTiVi` tinyint(1) DEFAULT NULL,
  `TroChoi` varchar(100) DEFAULT NULL,
  `LoaNgoai` tinyint(1) DEFAULT NULL,
  `GhiAm` varchar(100) DEFAULT NULL,
  `GhiAmCuocGoi` tinyint(1) DEFAULT NULL,
  `VideoCall` tinyint(1) DEFAULT NULL,
  `QuayPhim` varchar(100) DEFAULT NULL,
  `DoPhanGiaiMayAnh` double DEFAULT NULL,
  `MoTaMayAnh` varchar(300) DEFAULT NULL,
  `NhacChuong` int(11) DEFAULT NULL,
  `DinhDangNhacChuong` varchar(25) DEFAULT NULL,
  `TaiNhacChuong` tinyint(1) DEFAULT NULL,
  `BaoRung` tinyint(1) DEFAULT NULL,
  `ID_KieuDang` int(11) DEFAULT NULL,
  `ID_PhongCach` int(11) DEFAULT NULL,
  `ID_DongSanPham` int(11) DEFAULT NULL,
  `DanhBa` varchar(50) NOT NULL,
  `TinNhan` varchar(150) NOT NULL,
  `BoNhoTrong` varchar(30) DEFAULT NULL,
  `TheNho` varchar(150) DEFAULT NULL,
  `GPRS` tinyint(1) DEFAULT NULL,
  `TrinhDuyet` tinyint(1) DEFAULT NULL,
  `EDGE` tinyint(1) DEFAULT NULL,
  `HoTro3G` varchar(40) DEFAULT NULL,
  `UMTS` tinyint(1) DEFAULT NULL,
  `WCDMA` tinyint(1) DEFAULT NULL,
  `Wifi` varchar(25) DEFAULT NULL,
  `GPS` varchar(25) DEFAULT NULL,
  `HongNgoai` tinyint(1) DEFAULT NULL,
  `Bluetooth` tinyint(1) DEFAULT NULL,
  `USB` tinyint(1) DEFAULT NULL,
  `JavaApp` tinyint(1) DEFAULT NULL,
  `Office` tinyint(1) DEFAULT NULL,
  `ID_LoaiMang` int(11) DEFAULT NULL,
  `HaiSim` tinyint(1) DEFAULT NULL,
  `LoaiManHinh` varchar(25) DEFAULT NULL,
  `SoMauManHinh` int(11) DEFAULT NULL,
  `ChieuRongManHinh` int(11) DEFAULT NULL,
  `ChieuCaoManHinh` int(11) DEFAULT NULL,
  `CamUng` tinyint(1) DEFAULT NULL,
  `ChiTietCamUng` varchar(200) DEFAULT NULL,
  `LoaiPin` varchar(100) DEFAULT NULL,
  `DungLuong` int(11) DEFAULT NULL,
  `ThoiGianDamThoai` int(11) DEFAULT NULL,
  `ThoiGianCho` int(11) DEFAULT NULL,
  `ChieuRongDienThoai` int(11) DEFAULT NULL,
  `ChieuDaiDienThoai` int(11) DEFAULT NULL,
  `ChieuCaoDienThoai` int(11) DEFAULT NULL,
  `TrongLuong` int(11) DEFAULT NULL,
  `ID_HeDieuHanh` int(11) DEFAULT NULL,
  `NgonNgu` varchar(40) DEFAULT NULL,
  `BoBanHangChuan` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_SanPham`),
  KEY `ID_HangDienThoai` (`ID_HangDienThoai`),
  KEY `ID_PhongCach` (`ID_PhongCach`),
  KEY `ID_KieuDang` (`ID_KieuDang`),
  KEY `ID_DongSanPham` (`ID_DongSanPham`),
  KEY `ID_LoaiMang` (`ID_LoaiMang`),
  KEY `ID_HeDieuHanh` (`ID_HeDieuHanh`),
  CONSTRAINT `dienthoai_ibfk_1` FOREIGN KEY (`ID_SanPham`) REFERENCES `sanpham` (`ID`),
  CONSTRAINT `dienthoai_ibfk_2` FOREIGN KEY (`ID_HangDienThoai`) REFERENCES `hangdienthoai` (`ID`),
  CONSTRAINT `dienthoai_ibfk_3` FOREIGN KEY (`ID_PhongCach`) REFERENCES `phongcach` (`ID`),
  CONSTRAINT `dienthoai_ibfk_4` FOREIGN KEY (`ID_KieuDang`) REFERENCES `kieudang` (`ID`),
  CONSTRAINT `dienthoai_ibfk_5` FOREIGN KEY (`ID_DongSanPham`) REFERENCES `dongsanpham` (`ID`),
  CONSTRAINT `dienthoai_ibfk_6` FOREIGN KEY (`ID_LoaiMang`) REFERENCES `loaimang` (`ID`),
  CONSTRAINT `dienthoai_ibfk_7` FOREIGN KEY (`ID_HeDieuHanh`) REFERENCES `hedieuhanh` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dienthoai
-- ----------------------------
INSERT INTO `dienthoai` VALUES ('1', '1', 'MP3, WAV, WMV', 'MP4, 3GP  ', '1', '0', 'Cài đặt sẵn trong máy, có thể cài thêm  ', '1', 'Tùy thuộc bộ nhớ', '1', '1', 'Tùy thuộc bộ nhớ  ', '5', '2592x1944 pixels, Carl Zeiss optics, lấy nét tự động, Dual LED flash, video light; Camera phụ VGA', '64', 'MP3, MIDI, WAV  ', '1', '1', '4', '4', '2', 'Nhiều', 'SMS, MMS, Email, Push email, Instant Messaging  ', '32 GB', 'TransFlash ', '1', '1', '1', '10 (Mbps)  ', '1', '1', '1', 'Hỗ trợ A-GPS ', '0', '1', '1', '1', '1', '1', '0', 'TFT, 16 triệu màu', null, '480', '800', '1', 'Cảm ứng điện trở. Cảm biến tự động quay màn hình.  Rộng 3.5 inches\r\n- Rộng 3.5 inches', 'Pin chuẩn Li-Ion (BL-5J)  ', '1320', '6', '278', '60', '111', '18', '181', '5', 'Tiếng Anh  ', 'Thân máy, Pin BL-5J(1320mAh),tai nghe stereo WH-205,sạc AC-8E,adapter sạc CA-146,cáp Video,cáp kết nối CA-101,sách hướng dẫn, Sạc nhanh DC-11');

-- ----------------------------
-- Table structure for `dienthoai_phukien`
-- ----------------------------
DROP TABLE IF EXISTS `dienthoai_phukien`;
CREATE TABLE `dienthoai_phukien` (
  `ID_DienThoai` int(11) NOT NULL,
  `ID_PhuKien` int(11) NOT NULL,
  PRIMARY KEY (`ID_DienThoai`,`ID_PhuKien`),
  KEY `ID_PhuKien` (`ID_PhuKien`),
  CONSTRAINT `dienthoai_phukien_ibfk_1` FOREIGN KEY (`ID_DienThoai`) REFERENCES `dienthoai` (`ID_SanPham`),
  CONSTRAINT `dienthoai_phukien_ibfk_2` FOREIGN KEY (`ID_PhuKien`) REFERENCES `phukien` (`ID_SanPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dienthoai_phukien
-- ----------------------------
INSERT INTO `dienthoai_phukien` VALUES ('1', '6');
INSERT INTO `dienthoai_phukien` VALUES ('1', '7');

-- ----------------------------
-- Table structure for `dongsanpham`
-- ----------------------------
DROP TABLE IF EXISTS `dongsanpham`;
CREATE TABLE `dongsanpham` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dongsanpham
-- ----------------------------
INSERT INTO `dongsanpham` VALUES ('1', 'Siêu cấp');
INSERT INTO `dongsanpham` VALUES ('2', 'Cao cấp');
INSERT INTO `dongsanpham` VALUES ('3', 'Trung cấp');
INSERT INTO `dongsanpham` VALUES ('4', 'Phổ thông');

-- ----------------------------
-- Table structure for `donhang`
-- ----------------------------
DROP TABLE IF EXISTS `donhang`;
CREATE TABLE `donhang` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_KhachHang` int(11) DEFAULT NULL,
  `NgayTao` datetime NOT NULL,
  `HoTenNguoiNhan` varchar(80) NOT NULL,
  `SoDienThoaiNguoiNhan` varchar(15) NOT NULL,
  `DiaChiGiaoHang` varchar(150) NOT NULL,
  `ThoiGianGiaoHang` datetime NOT NULL,
  `ID_HinhThucThanhToan` int(11) DEFAULT NULL,
  `ID_TrangThai` int(11) DEFAULT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_KhachHang` (`ID_KhachHang`),
  KEY `ID_HinhThucThanhToan` (`ID_HinhThucThanhToan`),
  KEY `ID_TrangThai` (`ID_TrangThai`),
  CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`ID_KhachHang`) REFERENCES `khachhang` (`ID_Account`),
  CONSTRAINT `donhang_ibfk_2` FOREIGN KEY (`ID_HinhThucThanhToan`) REFERENCES `hinhthucthanhtoan` (`ID`),
  CONSTRAINT `donhang_ibfk_3` FOREIGN KEY (`ID_TrangThai`) REFERENCES `trangthaidonhang` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of donhang
-- ----------------------------

-- ----------------------------
-- Table structure for `gopy`
-- ----------------------------
DROP TABLE IF EXISTS `gopy`;
CREATE TABLE `gopy` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_KhachHang` int(11) DEFAULT NULL,
  `NoiDung` varchar(2000) NOT NULL,
  `ID_TrangThai` int(11) DEFAULT NULL,
  `NgayTao` datetime DEFAULT NULL,
  `HienThi` tinyint(1) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_KhachHang` (`ID_KhachHang`),
  KEY `ID_TrangThai` (`ID_TrangThai`),
  CONSTRAINT `gopy_ibfk_1` FOREIGN KEY (`ID_KhachHang`) REFERENCES `khachhang` (`ID_Account`),
  CONSTRAINT `gopy_ibfk_2` FOREIGN KEY (`ID_TrangThai`) REFERENCES `trangthaigopy` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gopy
-- ----------------------------
INSERT INTO `gopy` VALUES ('1', '1', 'Đây là góp ý 01', '1', '2010-05-27 13:21:59', '1', '0');
INSERT INTO `gopy` VALUES ('2', '1', 'Đây là góp ý 02', '1', '2010-05-27 13:22:27', '1', '0');
INSERT INTO `gopy` VALUES ('3', '1', 'Đây là góp ý 03', '1', '2010-05-27 13:22:43', '1', '0');
INSERT INTO `gopy` VALUES ('4', '2', 'Đây là góp ý 04', '2', '2010-05-27 13:23:01', '1', '0');
INSERT INTO `gopy` VALUES ('5', '2', 'Đây là góp ý 05', '2', '2010-05-27 13:23:14', '1', '0');
INSERT INTO `gopy` VALUES ('6', '2', 'Đây là góp ý 06', '2', '2010-05-27 13:23:27', '1', '0');
INSERT INTO `gopy` VALUES ('7', '3', 'Đây là góp ý 07', '3', '2010-05-27 13:23:45', '1', '0');
INSERT INTO `gopy` VALUES ('8', '3', 'Đây là góp ý 08', '3', '2010-05-27 13:23:58', '1', '0');
INSERT INTO `gopy` VALUES ('9', '3', 'Đây là góp ý 09', '3', '2010-05-27 13:24:14', '1', '0');

-- ----------------------------
-- Table structure for `hangdienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `hangdienthoai`;
CREATE TABLE `hangdienthoai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hangdienthoai
-- ----------------------------
INSERT INTO `hangdienthoai` VALUES ('1', 'Nokia');
INSERT INTO `hangdienthoai` VALUES ('2', 'LG');
INSERT INTO `hangdienthoai` VALUES ('3', 'Samsung');
INSERT INTO `hangdienthoai` VALUES ('4', 'Sony Ericssion');
INSERT INTO `hangdienthoai` VALUES ('5', 'HTC');
INSERT INTO `hangdienthoai` VALUES ('6', 'Motorola');
INSERT INTO `hangdienthoai` VALUES ('7', 'K-Touch');
INSERT INTO `hangdienthoai` VALUES ('8', 'Mobell');
INSERT INTO `hangdienthoai` VALUES ('9', 'F-Mobile');
INSERT INTO `hangdienthoai` VALUES ('10', 'Philips');
INSERT INTO `hangdienthoai` VALUES ('11', 'eTouch');
INSERT INTO `hangdienthoai` VALUES ('12', 'Apple');
INSERT INTO `hangdienthoai` VALUES ('13', 'BlackBerry');
INSERT INTO `hangdienthoai` VALUES ('14', 'S-Fone');
INSERT INTO `hangdienthoai` VALUES ('15', 'Khac');

-- ----------------------------
-- Table structure for `hedieuhanh`
-- ----------------------------
DROP TABLE IF EXISTS `hedieuhanh`;
CREATE TABLE `hedieuhanh` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) NOT NULL,
  `PhienBan` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hedieuhanh
-- ----------------------------
INSERT INTO `hedieuhanh` VALUES ('1', 'Other', null);
INSERT INTO `hedieuhanh` VALUES ('2', 'Symbian', null);
INSERT INTO `hedieuhanh` VALUES ('3', 'Android', null);
INSERT INTO `hedieuhanh` VALUES ('4', 'Windows Mobile', null);
INSERT INTO `hedieuhanh` VALUES ('5', 'RIM', null);
INSERT INTO `hedieuhanh` VALUES ('6', 'iPhone', null);
INSERT INTO `hedieuhanh` VALUES ('7', 'webOS', null);
INSERT INTO `hedieuhanh` VALUES ('8', 'Bada', null);

-- ----------------------------
-- Table structure for `hinhthucthanhtoan`
-- ----------------------------
DROP TABLE IF EXISTS `hinhthucthanhtoan`;
CREATE TABLE `hinhthucthanhtoan` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HinhThuc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hinhthucthanhtoan
-- ----------------------------
INSERT INTO `hinhthucthanhtoan` VALUES ('1', 'Paypal');
INSERT INTO `hinhthucthanhtoan` VALUES ('2', 'Chuyển khoản');
INSERT INTO `hinhthucthanhtoan` VALUES ('3', 'Tiền mặt');

-- ----------------------------
-- Table structure for `khachhang`
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `ID_Account` int(11) NOT NULL,
  PRIMARY KEY (`ID_Account`),
  CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`ID_Account`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT INTO `khachhang` VALUES ('1');
INSERT INTO `khachhang` VALUES ('2');
INSERT INTO `khachhang` VALUES ('3');
INSERT INTO `khachhang` VALUES ('4');
INSERT INTO `khachhang` VALUES ('5');
INSERT INTO `khachhang` VALUES ('6');
INSERT INTO `khachhang` VALUES ('7');

-- ----------------------------
-- Table structure for `kieudang`
-- ----------------------------
DROP TABLE IF EXISTS `kieudang`;
CREATE TABLE `kieudang` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kieudang
-- ----------------------------
INSERT INTO `kieudang` VALUES ('1', 'Other');
INSERT INTO `kieudang` VALUES ('2', 'Nấp gập');
INSERT INTO `kieudang` VALUES ('3', 'Thanh');
INSERT INTO `kieudang` VALUES ('4', 'Nắp trượt');
INSERT INTO `kieudang` VALUES ('5', 'Cảm ứng');
INSERT INTO `kieudang` VALUES ('6', 'Nắp xoay');
INSERT INTO `kieudang` VALUES ('7', 'Thân xoay');

-- ----------------------------
-- Table structure for `loaimang`
-- ----------------------------
DROP TABLE IF EXISTS `loaimang`;
CREATE TABLE `loaimang` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loaimang
-- ----------------------------
INSERT INTO `loaimang` VALUES ('1', 'GSM');
INSERT INTO `loaimang` VALUES ('2', 'CDMA');

-- ----------------------------
-- Table structure for `loaiphukien`
-- ----------------------------
DROP TABLE IF EXISTS `loaiphukien`;
CREATE TABLE `loaiphukien` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loaiphukien
-- ----------------------------
INSERT INTO `loaiphukien` VALUES ('1', 'Bao da');
INSERT INTO `loaiphukien` VALUES ('2', 'Vỏ máy');
INSERT INTO `loaiphukien` VALUES ('3', 'Pin');
INSERT INTO `loaiphukien` VALUES ('4', 'Sạc');
INSERT INTO `loaiphukien` VALUES ('5', 'Đồ trang trí');
INSERT INTO `loaiphukien` VALUES ('6', 'Thiết bị kết nối PC');
INSERT INTO `loaiphukien` VALUES ('7', 'Tai nghe');
INSERT INTO `loaiphukien` VALUES ('8', 'Loa');
INSERT INTO `loaiphukien` VALUES ('9', 'Thẻ nhớ & Đầu đọc thẻ');
INSERT INTO `loaiphukien` VALUES ('10', 'Phụ kiện khác');

-- ----------------------------
-- Table structure for `loaitintuc`
-- ----------------------------
DROP TABLE IF EXISTS `loaitintuc`;
CREATE TABLE `loaitintuc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LoaiTin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loaitintuc
-- ----------------------------
INSERT INTO `loaitintuc` VALUES ('1', 'Thông thường');
INSERT INTO `loaitintuc` VALUES ('2', 'Thông báo');
INSERT INTO `loaitintuc` VALUES ('3', 'Khuyến mãi');

-- ----------------------------
-- Table structure for `nhacungcap`
-- ----------------------------
DROP TABLE IF EXISTS `nhacungcap`;
CREATE TABLE `nhacungcap` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(80) NOT NULL,
  `DiaChi` varchar(80) NOT NULL,
  `DienThoai` varchar(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `GhiChu` varchar(200) DEFAULT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nhacungcap
-- ----------------------------
INSERT INTO `nhacungcap` VALUES ('1', 'NCC01', '34 Cầu Giấy Hà Nội', '043894562', 'ncc01@gmail.com', null, '0');
INSERT INTO `nhacungcap` VALUES ('2', 'NCC02', '12 Lý Chính Thằng Q3 TP HCM', '0837741852', 'ncc02@gmail.com', null, '0');
INSERT INTO `nhacungcap` VALUES ('3', 'NCC03', '189 Hùng Vương Q5 TP HCM', '083851954', 'ncc03@gmail.com', null, '0');

-- ----------------------------
-- Table structure for `nhanvien`
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien` (
  `ID_Account` int(11) NOT NULL,
  `CMND` varchar(15) NOT NULL,
  `Luong` double NOT NULL,
  `DiaChi` varchar(150) NOT NULL,
  `DienThoai` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_Account`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`ID_Account`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO `nhanvien` VALUES ('8', '654897852', '250', '34 CMT8 P.13 Q.Tân Bình TP.HCM', '0939456123');
INSERT INTO `nhanvien` VALUES ('9', '789159753', '300', '134 Trần Hữu Trang P.12 Q.Phú Nhuận TP.HCM', '0939452159');
INSERT INTO `nhanvien` VALUES ('10', '153759846', '275', '89 Lý Thường Kiệt P.5 Q.Tân Bình TP.HCM', '0939789456');

-- ----------------------------
-- Table structure for `nhanvienquanly`
-- ----------------------------
DROP TABLE IF EXISTS `nhanvienquanly`;
CREATE TABLE `nhanvienquanly` (
  `ID_Account` int(11) NOT NULL,
  `CMND` varchar(15) NOT NULL,
  `Luong` double NOT NULL,
  `DiaChi` varchar(150) NOT NULL,
  `DienThoai` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_Account`),
  CONSTRAINT `nhanvienquanly_ibfk_1` FOREIGN KEY (`ID_Account`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nhanvienquanly
-- ----------------------------
INSERT INTO `nhanvienquanly` VALUES ('11', '741258963', '350', '45 Sư Vạn Hạnh P.2 Q.10 TP.HCM', '0939785146');
INSERT INTO `nhanvienquanly` VALUES ('12', '582468729', '350', '34/56 Hùng Vương P.4 Q.5 TP.HCM', '0939451456');
INSERT INTO `nhanvienquanly` VALUES ('13', '125751349', '375', '123/34 Âu Cơ P.5 Q.Tân Phú TP.HCM', '0939789456');

-- ----------------------------
-- Table structure for `nhanvienquantri`
-- ----------------------------
DROP TABLE IF EXISTS `nhanvienquantri`;
CREATE TABLE `nhanvienquantri` (
  `ID_Account` int(11) NOT NULL,
  `CMND` varchar(15) NOT NULL,
  `Luong` double NOT NULL,
  `DiaChi` varchar(150) NOT NULL,
  `DienThoai` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_Account`),
  CONSTRAINT `nhanvienquantri_ibfk_1` FOREIGN KEY (`ID_Account`) REFERENCES `account` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nhanvienquantri
-- ----------------------------
INSERT INTO `nhanvienquantri` VALUES ('14', '256134842', '350', '87/12 Lạc Long Quân P.2 Q.Tân Bình TP.HCM', '0939746851');
INSERT INTO `nhanvienquantri` VALUES ('15', '512481726', '350', '14/76 Hồng Lạc P.4 Q.Tân Bình TP.HCM', '0939845761');
INSERT INTO `nhanvienquantri` VALUES ('16', '135682462', '400', '86/34 An Dương Vương P.5 Q.5 TP.HCM', '0939421876');

-- ----------------------------
-- Table structure for `nhanxetdienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `nhanxetdienthoai`;
CREATE TABLE `nhanxetdienthoai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DienThoai` int(11) DEFAULT NULL,
  `ID_KhachHang` int(11) DEFAULT NULL,
  `TongQuan` varchar(500) DEFAULT NULL,
  `UuDiem` varchar(500) NOT NULL,
  `NhuocDiem` varchar(500) NOT NULL,
  `DanhGia` int(11) NOT NULL,
  `ThoiGian` datetime NOT NULL,
  `HienThi` tinyint(1) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_DienThoai` (`ID_DienThoai`),
  KEY `ID_KhachHang` (`ID_KhachHang`),
  CONSTRAINT `nhanxetdienthoai_ibfk_1` FOREIGN KEY (`ID_DienThoai`) REFERENCES `dienthoai` (`ID_SanPham`),
  CONSTRAINT `nhanxetdienthoai_ibfk_2` FOREIGN KEY (`ID_KhachHang`) REFERENCES `khachhang` (`ID_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nhanxetdienthoai
-- ----------------------------

-- ----------------------------
-- Table structure for `phieunhapdienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `phieunhapdienthoai`;
CREATE TABLE `phieunhapdienthoai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_NhanVien` int(11) DEFAULT NULL,
  `ID_NhaCungCap` int(11) DEFAULT NULL,
  `NgayNhap` date NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_NhanVien` (`ID_NhanVien`),
  KEY `ID_NhaCungCap` (`ID_NhaCungCap`),
  CONSTRAINT `phieunhapdienthoai_ibfk_1` FOREIGN KEY (`ID_NhanVien`) REFERENCES `nhanvien` (`ID_Account`),
  CONSTRAINT `phieunhapdienthoai_ibfk_2` FOREIGN KEY (`ID_NhaCungCap`) REFERENCES `nhacungcap` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phieunhapdienthoai
-- ----------------------------

-- ----------------------------
-- Table structure for `phieunhapphukien`
-- ----------------------------
DROP TABLE IF EXISTS `phieunhapphukien`;
CREATE TABLE `phieunhapphukien` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_NhanVien` int(11) DEFAULT NULL,
  `ID_NhaCungCap` int(11) DEFAULT NULL,
  `NgayNhap` date NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_NhanVien` (`ID_NhanVien`),
  KEY `ID_NhaCungCap` (`ID_NhaCungCap`),
  CONSTRAINT `phieunhapphukien_ibfk_1` FOREIGN KEY (`ID_NhanVien`) REFERENCES `nhanvien` (`ID_Account`),
  CONSTRAINT `phieunhapphukien_ibfk_2` FOREIGN KEY (`ID_NhaCungCap`) REFERENCES `nhacungcap` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phieunhapphukien
-- ----------------------------

-- ----------------------------
-- Table structure for `phongcach`
-- ----------------------------
DROP TABLE IF EXISTS `phongcach`;
CREATE TABLE `phongcach` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phongcach
-- ----------------------------
INSERT INTO `phongcach` VALUES ('1', 'None');
INSERT INTO `phongcach` VALUES ('2', 'Doanh nhân');
INSERT INTO `phongcach` VALUES ('3', 'Cá tính');
INSERT INTO `phongcach` VALUES ('4', 'Nam tính');
INSERT INTO `phongcach` VALUES ('5', 'Nữ tính');
INSERT INTO `phongcach` VALUES ('6', 'Thời trang');
INSERT INTO `phongcach` VALUES ('7', 'Trẻ trung');

-- ----------------------------
-- Table structure for `phukien`
-- ----------------------------
DROP TABLE IF EXISTS `phukien`;
CREATE TABLE `phukien` (
  `ID_SanPham` int(11) NOT NULL,
  `MauSac` varchar(50) DEFAULT NULL,
  `TinhNang` varchar(1000) NOT NULL,
  `HuongDanSuDung` varchar(1000) DEFAULT NULL,
  `ID_LoaiPhuKien` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_SanPham`),
  KEY `ID_LoaiPhuKien` (`ID_LoaiPhuKien`),
  CONSTRAINT `phukien_ibfk_1` FOREIGN KEY (`ID_SanPham`) REFERENCES `sanpham` (`ID`),
  CONSTRAINT `phukien_ibfk_2` FOREIGN KEY (`ID_LoaiPhuKien`) REFERENCES `loaiphukien` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phukien
-- ----------------------------
INSERT INTO `phukien` VALUES ('2', null, 'Adapter T-F mini dùng để thay thế cho thẻ Mini SD.Lấy thẻ Transflash (T-F) gắn vào Adapter Mini sẽ sử dụng được cho máy dùng thẻ Mini SD , tiện dụng , cho các dòng máy sử dụng thẻ T-F và Mini SD.', null, '9');
INSERT INTO `phukien` VALUES ('3', '1 màu', 'Đầu đọc 2 in 1 dùng để đọc thẻ T-F ( transflash ) không cần adapter đọc thẻ .\r\n\r\n- Đầu đọc 2 in 1 nhỏ gọn , có thể dùng làm USB mini  , tiện lợi \r\n\r\n- Chuyển dữ liệu từ máy đt sang máy tính , nhanh chóng , dễ dàng.\r\n\r\n- Dùng làm đồ trang trí khi mang theo\r\n\r\nKhi mua quý khách sẽ được nhân viên bán hàng hướng dẫn tính năng sử dụng .\r\n\r\nĐầu đọc 2 in 1 dùng để đọc thẻ T-F ( transflash ) không cần adapter đọc thẻ. Đầu đọc 2 in 1 nhỏ gọn , có thể dùng làm USB mini  , tiện lợi. Chuyển dữ liệu từ máy đt sang máy tính , nhanh chóng , dễ dàng. Dùng làm đồ trang trí khi mang theo.', null, '9');
INSERT INTO `phukien` VALUES ('4', null, 'Phụ kiện dùng để đọc dữ liệu từ thẻ nhớ của các model điện thoại di động có hỗ trợ thẻ nhớ . Bạn có thể tự chép hình, nhạc , phim , trò chơi , ứng dụng , ... vào thẻ nhớ của mình một cách dễ dàng hoặc lấy dữ liệu từ thẻ nhớ lên máy tính để xử lý . Đọc được hầu hết các loại thẻ nhớ thông dụng hiện nay như SD, MMC , Memory Stick Duo ,...\r\nKhi mua tại Thế Giới Di Động bạn sẽ được hướng dẫn cụ thể trước khi sử dụng.', null, '9');
INSERT INTO `phukien` VALUES ('5', '1 màu', 'Phụ kiện dùng để đọc dữ liệu từ thẻ nhớ của các model điện thoại di động có hỗ trợ thẻ nhớ . Bạn có thể tự chép hình, nhạc , phim , trò chơi , ứng dụng , ... vào thẻ nhớ của mình một cách dễ dàng hoặc lấy dữ liệu từ thẻ nhớ lên máy tính để xử lý . Đọc được hầu hết các loại thẻ nhớ thông dụng hiện nay như SD, MMC , Memory Stick Duo ,...Khi mua tại Thế Giới Di Động bạn sẽ được hướng dẫn cụ thể trước khi sử dụng.', null, '9');
INSERT INTO `phukien` VALUES ('6', null, 'Thẻ T-F thegioididong chất lượng cao , khả năng lưu trữ lớn và tốc độ truyền dữ liệu cao. Với thẻ nhớ này bạn có thể lưu trữ được rất nhiều dữ liệu hình ảnh, nhạc chuông, ứng dụng, phim ảnh...', null, '9');
INSERT INTO `phukien` VALUES ('7', null, 'Thẻ T-F thegioididong chất lượng cao , khả năng lưu trữ lớn và tốc độ truyền dữ liệu cao. Với thẻ nhớ này bạn có thể lưu trữ được rất nhiều dữ liệu hình ảnh, nhạc chuông, ứng dụng, phim ảnh...', null, '9');
INSERT INTO `phukien` VALUES ('8', null, 'DV RS - MMC (Digital Volt Redusized - MultiMedia Card): thẻ nhớ đa phương tiện kích thước thu nhỏ (chỉ bằng 2/3 so với thẻ nhớ MMC) dùng để mở rộng thêm bộ nhớ của máy, hỗ trợ cho việc lưu trữ dữ liệu, chép thêm nhiều hình ảnh, nhạc chuông, trò chơi, phim ảnh, ứng dụng...kích thước nhỏ có thể ghi xóa dữ liệu dễ dàng...', null, '9');
INSERT INTO `phukien` VALUES ('9', null, 'Thẻ nhớ M2 do Sony thiết kế , kích thước bằng 1/2 so với thẻ Produal , tốc độ truyền đọc dữ liệu cao , giúp cho việc truyền tải dữ liệu nhanh chóng và thuận tiện..Với thẻ nhớ này bạn có thể lưu trữ được rất nhiều dữ liệu hình ảnh, nhạc chuông, ứng dụng, phim ảnh..', null, '9');
INSERT INTO `phukien` VALUES ('10', null, 'Phụ kiện dùng để đọc dữ liệu từ thẻ nhớ của các model điện thoại di động có hỗ trợ thẻ nhớ . Bạn có thể tự chép hình, nhạc , phim , trò chơi , ứng dụng , ... vào thẻ nhớ của mình một cách dễ dàng hoặc lấy dữ liệu từ thẻ nhớ lên máy tính để xử lý . Đọc được hầu hết các loại thẻ nhớ thông dụng hiện nay như SD, MMC , Memory Stick Duo ,...Khi mua tại Thế Giới Di Động bạn sẽ được hướng dẫn cụ thể trước khi sử dụng.', null, '9');
INSERT INTO `phukien` VALUES ('11', null, 'Thẻ nhớ M2 do Sony thiết kế , kích thước bằng 1/2 so với thẻ Produal , tốc độ truyền đọc dữ liệu cao , giúp cho việc truyền tải dữ liệu nhanh chóng và thuận tiện. Với thẻ nhớ này bạn có thể lưu trữ được rất nhiều dữ liệu hình ảnh, nhạc chuông, ứng dụng, phim ảnh.', null, '9');
INSERT INTO `phukien` VALUES ('12', null, 'Thẻ T-F thegioididong chất lượng cao , khả năng lưu trữ lớn và tốc độ truyền dữ liệu cao. Với thẻ nhớ này bạn có thể lưu trữ được rất nhiều dữ liệu hình ảnh, nhạc chuông, ứng dụng, phim ảnh...Lưu ý: với một số Model thì bạn phải sử đầu nối (Adapter) thẻ đi kèm thì mới sử dụng được. Khi gắn Adapter này thì bạn có thể sử dụng như thẻ mini SD  , SD bình thường', null, '9');
INSERT INTO `phukien` VALUES ('13', null, 'DV RS - MMC (Digital Volt Redusized - MultiMedia Card): thẻ nhớ đa phương tiện kích thước thu nhỏ (chỉ bằng 2/3 so với thẻ nhớ MMC) dùng điện thế kép (1.8/3 volt), dùng để mở rộng thêm bộ nhớ của máy, hỗ trợ cho việc lưu trữ dữ liệu, chép thêm nhiều hình ảnh, nhạc chuông, trò chơi, phim ảnh, ứng dụng...kích thước nhỏ có thể ghi xóa dữ liệu dễ dàng...', null, '9');
INSERT INTO `phukien` VALUES ('14', 'Đen', 'Bao da dựng điện thoại cao cấp , không chỉ bảo vệ chiếc \" Dế \" cưng của bạn khỏi bị trầy xướt mà còn làm tăng sự tự tin và phong cách sành điệu.', null, '1');
INSERT INTO `phukien` VALUES ('15', 'Đen', 'Bao da dựng điện thoại cao cấp , không chỉ bảo vệ chiếc \" Dế \" cưng của bạn khỏi bị trầy xướt mà còn làm tăng sự tự tin và phong cách sành điệu.', null, '1');
INSERT INTO `phukien` VALUES ('16', 'Đen', 'Bao da dựng điện thoại cao cấp , không chỉ bảo vệ chiếc \" Dế \" cưng của bạn khỏi bị trầy xướt mà còn làm tăng sự tự tin và phong cách sành điệu.', null, '1');
INSERT INTO `phukien` VALUES ('17', 'Đen', 'Bao da dựng điện thoại cao cấp , không chỉ bảo vệ chiếc \" Dế \" cưng của bạn khỏi bị trầy xướt mà còn làm tăng sự tự tin và phong cách sành điệu.', null, '1');
INSERT INTO `phukien` VALUES ('18', 'Đen', 'Bao da dựng điện thoại cao cấp , không chỉ bảo vệ chiếc \" Dế \" cưng của bạn khỏi bị trầy xướt mà còn làm tăng sự tự tin và phong cách sành điệu.', null, '1');
INSERT INTO `phukien` VALUES ('19', null, 'Túi tay cầm bằng da bảo vệ điện thoại khỏi bị trầy xướt , kiểu dáng đẹp , phù hợp cho mọi lứa tuổi. ', null, '1');
INSERT INTO `phukien` VALUES ('20', null, 'Túi tay cầm điện thoại giúp bảo vệ điện thoại tránh bị trầy xước , kiểu dáng đẹp , thích hợp cho mọi lứa tuổi.', null, '1');
INSERT INTO `phukien` VALUES ('21', 'Nhiều màu sắc', 'Túi Golla máy ảnh thời trang dành cho mọi lứa tuổi , kiểu dáng sang trọng  , dùng để đựng điện thoại hoặc máy ảnh , máy nghe nhạc MP3 ...', null, '1');
INSERT INTO `phukien` VALUES ('22', 'Nâu đen', 'Túi tay Golla điện thoại giúp bảo vệ điện thoại tránh bị trầy xước , kiểu dáng đẹp , thích hợp cho mọi lứa tuổi.', null, '1');
INSERT INTO `phukien` VALUES ('23', 'Nhiều màu', 'Vỏ nhựa Iphone dùng để bảo vệ máy khỏi trầy xướt , mhư vỏ cozip , nhưng giá thành thấp hơn.', null, '2');
INSERT INTO `phukien` VALUES ('24', 'Nhiều màu', 'Vỏ silicon Iphone chất liệu mềm , êm tay , kiểu dáng đẹp , giúp bảo vệ điện thoại tránh trầy xướt. Dùng cho tất cả các dòng điện thoại iPhone.', null, '2');
INSERT INTO `phukien` VALUES ('25', '1 màu', 'Vỏ phát quang Iphone giúp bảo vệ điện thoại trống trầy xướt , phát quang trong bóng đêm , tạo sự khác biệt cho chiếc dế cưng của bạn trong đêm tối huyền bí.', null, '2');
INSERT INTO `phukien` VALUES ('26', null, 'Pin BLD-2 ( 8210 ) TGDD dùng cho các dòng máy Nokia , 8210 , 8250  , 5210 , 6510 , 7650....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng. - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng', '3');
INSERT INTO `phukien` VALUES ('27', null, 'Pin BLD-3 (7210) TGDD dành cho các dòng máy Nokia .7210 , 6610 ,7250 , 7250i , 6610i , ....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .- Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('28', null, 'Pin BL-4B TGDD pin chất lượng tốt , dành cho các dòng máy nokia 6111 , 2630 , 7370 , 7373 , 7500 , N76 .....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .- Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('29', null, 'in E680 TGDD dành cho các dòng máy Moto : Moto E680...', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng. - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('30', null, 'Pin BL-5C TGDD dành cho các dòng máy Nokia : 3650 , 6230 , 6270, 6600, 6680, 6681, Ngage QD ,N 91, N70, N72 .......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng. - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('31', null, 'Pin BL - 4C TGDD , pin chất lượng tốt , sử dụng cho các dòng máy Nokia 2650 , 2652 , 5100 , 6100 , 6101....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng. - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('32', null, 'Pin BL-5B TGDD , chất lượng tốt , sử dụng cho các dòng máy Nokia 7260 , 3220 , 2310 , 3230...', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng . \\r\\n- Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng', '3');
INSERT INTO `phukien` VALUES ('33', null, 'Pin V3 TGDD , Pin chất lượng cao , dùng cho các dòng máy Motorola V3 , U6...', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng.  - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('34', null, 'Pin V8 TGDD , Pin chất lượng cao , dùng cho các dòng máy Motorola V8 ', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng. - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('35', null, 'Pin L7 TGDD chất luợng cao  , sử dụng cho các dòng máy Motorola L7 , L7i , L72........', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng. - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('36', null, 'Pin BST_38 TGDD , pin chất lượng cao  , pin dùng cho các dòng máy Sony , W580i , K850i , W760 , S500......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng . - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('37', null, 'Pin BST-36 TGDD dành cho các dòng máy Sony : W200 ,K330 , K310i ,J300 , K320i ,K510i , Z310i , Z320i , Z550i ......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng . - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng. ', '3');
INSERT INTO `phukien` VALUES ('38', null, 'Pin BST - 40 TGDD dành cho các dòng máy Sony : P1i ......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('39', null, 'Pin Sam Sung C170 TGDD dành cho các dòng máy Sam Sung : C170....C178.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('40', null, 'Pin Sam Sung D528 TGDD dành cho các dòng Sam Sung : C260 , E250 ,F250 ,B300.......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('41', null, 'Pin Sony BST-30 TGDD dành cho các dòng máy Sony : F500 , K300i ,K500i , K700i.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('42', null, 'Pin Sony BST- 37 TGDD dành cho các dòng máy Sony : K750 , J100 , J110 , W350i ,W700.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng', '3');
INSERT INTO `phukien` VALUES ('43', null, 'Pin Sony BST-33 TGDD dành cho các dòng máy Sony : W880i ,C702 ,G502 ,K800 ,K790i ,W610.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('44', null, 'Pin Sony BST-39 TGDD dành cho các dòng máy Sony : W910i , Z555i.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng', '3');
INSERT INTO `phukien` VALUES ('45', null, 'Pin Moto BT-50  dành cho các dòng máy Moto : W275.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('46', null, 'Pin Sam Sung D900 TGDD dành cho các dòng máy Sam Sung : D900 ,D908 ,E788....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('47', null, 'Pin Sam Sung J700 TGDD dành cho các dòng máy Sam Sung : J700......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('48', null, 'Pin Moto BQ-50 dành cho các dòng Moto : W230 .....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('49', null, 'Pin Sam sung B100 TGDD dành cho các dòng máy Sam Sung : B500 ,E210 ,C300.....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('50', null, ' Pin BL-5F TGDD , pin chất lượng tốt , sử dụng cho các dòng máy Nokia 6290 , E65 , N95....', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('51', null, 'Pin 6M TGDD pin chất lượng tốt dùng cho các dòng máy Nokia , N93 , N73 , 9300 , 3250  ......', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('52', null, 'Pin 6X TGDD , pin chất lượng cao , sử dụng cho các dòng máy Nokia: Nokia 8800 , Nokia 8800 Sirocco Edition black , Nokia 8800 Sirocco Edition Gold , Nokia 8800 Sirocco Edition Silver , Nokia 8800 Special Edition , Nokia 8800 Special Edition (Promotion).', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('53', null, 'Pin 5M TGDD dành cho các dòng máy nokia : 8600 luna , 5700 ,6110 , 5610 ,6500 , 7390 , 6220 classic...', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('54', null, 'Pin BP-4L TGDD , Pin chất lượng tốt sử dụng cho các dòng máy Nokia E71, E75 ,N97 , E61i...', '- Đối với Pin mới : \r\n + Dùng cho đến khi điện thoại báo \" pin yếu\" gắm sạc 8 tiếng , \r\n + 3 lần đầu tiên sạc pin 8 tiếng , trong quá trình sạc 3 lần đầu 8 tiếng , điện thoại sẽ báo đầy pin , thì vẫn để chế độ cắm sạc cho đến 8 tiếng .\r\n\r\n - Đối với Pin đã qua 3 lần đầu sạc 8 tiếng : \r\n  + Mỗi lần sạc Pin tối đa là 3 tiếng thì pin đầy , rút ra sử dụng , tránh sạc Pin quá lâu hoặc sạc qua đêm nhiều lần , rất dễ làm pin điện thoại nóng và bị phù\r\n  + Trong lúc sạc Pin nếu có điện thoại gọi đến , thì rút sạc ra khỏi điện thoại để nghe .\r\n  + Không để Pin ở nơi có nhiệt độ cao \r\n  + Không nên dùng \" sạc đa năng \" sạc pin mới 3 lần đầu 8 tiếng.', '3');
INSERT INTO `phukien` VALUES ('55', 'Đen', 'Sạc đa năng dùng để sạc cho hầu hết các loại pin của Nokia, Samsung, Sony Ericsson, Siemens , Motorola , wellcom , Bavapen , mobell.......', null, '4');
INSERT INTO `phukien` VALUES ('56', 'Đen', 'Sạc Samsung dành cho các máy Samsung D800, D820, D840, D900....', null, '4');
INSERT INTO `phukien` VALUES ('57', 'Đen', 'Sạc Motorola V3 dùng cho các dòng máy có sử dụng đuôi sạc V3', null, '4');
INSERT INTO `phukien` VALUES ('58', 'Đen', 'Sạc Nokia N70 dành cho các dòng máy Nokia có chấu sạc đầu nhỏ.', null, '4');
INSERT INTO `phukien` VALUES ('59', 'Đen', 'Sạc Samsung E210 dùng cho các dòng máy sam sung , E 210 ......', null, '4');
INSERT INTO `phukien` VALUES ('60', 'Đen', 'Sạc K800 dùng để sạc dành cho các dòng máy Sony ,K750 K8000  , W 810............', null, '4');
INSERT INTO `phukien` VALUES ('61', 'Nhiều màu', 'Sạc USB điện thoại dùng để sạc điện thoại  qua cổng USB máy tính. Sạc dùng cho các máy Nokia , Motorola , Samsung , Sony , LG ', null, '4');
INSERT INTO `phukien` VALUES ('62', null, 'Sạc LG KG800 dùng cho các dòng LG KG 800 , KE 970 , KE 770 , KF 510 , KE 990 ,EF 600 , KM 380 , KP 220 , KP 320', null, '4');
INSERT INTO `phukien` VALUES ('63', 'Đen', 'Sạc khẩn cấp chỉ sử dụng khi điện thoại báo Pin yếu và có thể dùng sạc Khẩn Cấp để nghe và gọi điện thoại liên tục lên đến 2h.', null, '4');
INSERT INTO `phukien` VALUES ('64', 'Đen', 'Sạc khẩn cấp chỉ sử dụng khi điện thoại báo Pin yếu và có thể cắm sạc Khẩn Cấp để nghe và gọi điện thoại liên tục lên đến 2h', 'Dùng pin tiểu AA , duy trì nguồn pin điện thoại trong vòng 2 ngày.', '4');
INSERT INTO `phukien` VALUES ('65', 'Trắng', 'Sạc nhanh Iphone dùng cho các dòng máy Iphone.', null, '4');
INSERT INTO `phukien` VALUES ('66', 'Đen', 'Sạc xe hơi DC-6 dùng cho các dòng mới 8600 luna , thuận tiện sử dụng khi đi trên xe hơi , hàng chính hãng', null, '4');
INSERT INTO `phukien` VALUES ('67', 'Đen', 'Sạc khẩn cấp chỉ sử dụng khi điện thoại báo Pin yếu và có thể cắp sạc Khẩn Cấp để nghe và gọi điện thoại liên tục lên đến 3h. Hỗ trợ cho các dòng điện thoại như Nokia đầu lớn , nokia đầu nhỏ , sam sung D500 , E350 , X430 ...Sony K750 , W810 , W660 , W580 ......Motorola.', 'Dùng pin tiểu AA , duy trì nguồn pin điện thoại trong vòng 2 ngày.', '4');
INSERT INTO `phukien` VALUES ('68', 'Đen', 'Sạc Dự Phòng là loại sạc được cải tiến tối ưu hóa từ sạc khẩn cấp , \r\nLấy năng lượng  trực tiếp từ điện nguồn để dự trữ và chuyển tải năng lượng cho Pin điên thoại , \r\nLưu trữ nguồn điện lên đến 7 ngày , \r\nSạc đầy Pin cho điện thoại lên đến 3 lần sạc\r\nHiện các có các loại sạc dự phòng :\r\nSạc dự Phòng Iphone \r\nSạc dự Phòng nokia đầu nhỏ\r\nSạc dự phòng đầu USB mini\r\nSạc dự phòn LG\r\nSạc dự phòng Samsung E210', 'Cung cấp năng lượng đầy pin cho dế yêu của bạn lên đến 2 lần .\r\nLưu trữ nguồn năng lượng lên đến 7 ngày\r\nCó tính hiệu báo khi thiết bị nhận đầy pin\r\nCó nhiều loại cho nhiều model điện thoại như , Iphone , đầu USB Mini , sạc đầu nhỏ Nokia, samsung E210 , LG.', '4');
INSERT INTO `phukien` VALUES ('69', 'Nhiều màu', 'Có hơn 100 lọai Dây đeo trang trí điện thoại , sành điệu , hợp thời trang , sử dụng cho nhiều dòng máy diện thoại khác nhau', null, '5');
INSERT INTO `phukien` VALUES ('70', null, 'Miếng dán trang trí điện thoại dùng để trang trí điện thoại thêm xinh đẹp , nhiều màu sắc và hình ảnh xinh xắn  , kiểu dáng mới lạ , giúp cho điện thoại trông xinh hơn  và giúp điện thoại của bạn tránh khỏi trầy xướt ..', null, '5');
INSERT INTO `phukien` VALUES ('71', null, 'Miếng dán màn hình Iphone , giúp bảo vệ màn hình cách tốt nhất , khỏi bị trầy xướt , \r\n Với miếng dán màn hình bảo vệ , hình ảnh trên điện thoại luôn sắc nét và rõ ràng nh', null, '5');
INSERT INTO `phukien` VALUES ('72', null, 'Miếng dán bảo vệ màn hình giúp bảo vệ màn hình điện thoại khỏi bị trầy xướt , phù hợp cho tất cả các dòng điện thoại ,\r\n Với miếng dán bảo vệ màn hình điện thoại , hình ảnh trên điện thoại luôn sắc nét và rõ ràng nhất.', null, '5');
INSERT INTO `phukien` VALUES ('73', 'Đen', 'Phụ kiện dùng để kết nối máy tính với điện thoại di động để tải nhạc, hình, trò chơi, ứng dụng, đồng bộ dữ liệu... Giao tiếp qua cổng USB của máy tính, nhận ra như một ổ đĩa USB, bạn có thể dễ dàng lấy hình ảnh của mình lên máy tính. Có đĩa driver, phần mềm và sách hướng dẫn đi kèm\r\n\r\nKhi mua bạn sẽ được tặng 01 đĩa CD có chứa rất nhiều hình, nhạc, trò chơi, ứng dụng, phần mềm giao tiếp, phần mềm giúp biên soạn âm thanh, hình ảnh, ... Bạn sẽ được hướng dẫn cụ thể cách thức sử dụng cáp và phần mềm giao tiếp khi mua tại thegioididong.', null, '6');
INSERT INTO `phukien` VALUES ('74', 'Đen', 'Phụ kiện dùng để kết nối máy tính với điện thoại di động để tải nhạc, hình, trò chơi, ứng dụng, đồng bộ dữ liệu...Bạn có thể dễ dàng lấy những ành chụp từ máy điện thọai của mình lên máy tính ... Giao tiếp qua cổng USB của máy tính. Có đĩa driver, phần mềm và sách hướng dẫn đi kèm.\r\n\r\nDùng được cho nhiều model Samsung D820 , E 250 ......\r\n\r\nKhi mua bạn sẽ được tặng 01 đĩa CD có chứa rất nhiều hình, nhạc, trò chơi, ứng dụng, phần mềm giao tiếp, phần mềm giúp biên soạn âm thanh, hình ảnh, ... Bạn sẽ được hướng dẫn chi tiết cách thức sử dụng cáp và phần mềm giao tiếp khi mua tại siêu thị thegioididong.com', null, '6');
INSERT INTO `phukien` VALUES ('75', 'Đen', 'Cáp micro USB TGDD dùng để tải nhạc hình , phim , để cho máy bạn thêm phong phú các bộ sưu tập , do chính bạn thiết kế .....dùng cho các dòng máy Nokia , Motorola .....', null, '6');
INSERT INTO `phukien` VALUES ('76', 'Đen', 'Cáp  Mini USB TGDD dùng để tải nhạc hình , phim , để cho máy bạn thêm phong phú các bộ sưu tập , do chính bạn thiết kế .....dùng được cho nhiều dòng máy có chấu kết nối bằng cổng Mini USB .....', null, '6');
INSERT INTO `phukien` VALUES ('77', null, 'Phụ kiện dùng để kết nối máy tính với điện thoại di động để tải nhạc, hình, trò chơi, ứng dụng, đồng bộ dữ liệu, ... Giao tiếp qua cổng USB của máy tính. Có đĩa driver tặng kèm.\r\n\r\nDùng chung được cho các model Nokia 3230, Nokia 6111, Nokia 6170, Nokia 6230, Nokia 6230i, Nokia 6260, Nokia 6270, Nokia 6280, Nokia 6630, Nokia 6650, Nokia 6670, Nokia 6680, Nokia 6681, Nokia 6810, Nokia 7270 black, Nokia 7270 red, Nokia 7610, Nokia 7700, Nokia 9300, Nokia 9500, Nokia N70, Nokia N90... \r\n\r\nKhi mua bạn sẽ được tặng 01 đĩa CD có chứa rất nhiều hình, nhạc, trò chơi, ứng dụng, phần mềm giao tiếp, phần mềm giúp biên soạn âm thanh, hình ảnh, ... Bạn sẽ được hướng dẫn cụ thể cách thức sử dụng cáp và phần mềm giao tiếp khi mua tại thegioididong.', null, '6');
INSERT INTO `phukien` VALUES ('78', null, 'Cáp Iphone TGDD dùng để tải , nhạc , hình , dữ liệu , dùng cho các dòng Iphone : Iphone 4G , 8G , 16G ...', null, '6');
INSERT INTO `phukien` VALUES ('79', 'Đen', 'Cổng Bluetooth dùng để kết nối trao đổi dữ liệu Bluetooth từ thiết bị máy tính sang những thiêt bị Bluetooth khác', null, '6');
INSERT INTO `phukien` VALUES ('80', '1 màu', 'Tai nghe Sony Ericsson TGDD . Hỗ trợ đàm thoại, nghe nhạc,... với chất lượng âm thanh trung thực cho các dòng máy Sony Ericsson.', null, '7');
INSERT INTO `phukien` VALUES ('81', '1 màu', 'Tai nghe Samsung D820 TGDD . Hỗ trợ tính năng đàm thoại và nghe nhạc, chất lượng âm thanh hoàn hảo.sử dụng cho các dòng máy sam sung có jack D820', null, '7');
INSERT INTO `phukien` VALUES ('82', null, 'Tai nghe Nokia hỗ trợ nghe nhạc và đàm thoại, dành cho các Model Nokia: 3250 XpressMusic, 5500 Sport, 6070, 6080, 6085, 6086, 6101, 6103, 6111, 6125, 6131, ........', null, '7');
INSERT INTO `phukien` VALUES ('83', null, 'Tai nghe Nokia 6300 TGDD , chất lượng cao , âm thanh chuẩn , dành cho các dòng máy có jack 2,5mm , 6300 , 5200....... ', null, '7');
INSERT INTO `phukien` VALUES ('84', null, 'Tai nghe IPOD TGDD jack 3,5 mm , dùng chung cho các dòng máy có jack 3,5 mm.', null, '7');
INSERT INTO `phukien` VALUES ('85', 'Trắng', 'TAI NGHE SAM SUNG E210 TGDD', null, '7');
INSERT INTO `phukien` VALUES ('86', '1 màu', 'TAI NGHE NOKIA N73 TGDD', null, '7');
INSERT INTO `phukien` VALUES ('87', null, 'Tai nghe Tai nghe N95 TGDD. Hỗ trợ tính năng đàm thoại và nghe nhạc, chất lượng âm thanh chuẩn . Hãy cùng tai nghe N95 TGDD cảm nhận âm nhạc của cuộc sống ........', null, '7');
INSERT INTO `phukien` VALUES ('88', null, 'Tai nghe Di động Âm thanh nổi HPM-82 của bạn có đầu cắm 3,5mm tích hợp giúp bạn chuyển sang tai nghe để nghe nhạc trong điện thoại theo cách mong muốn. Tiện ích thỏa mãn đôi tai.', null, '7');
INSERT INTO `phukien` VALUES ('89', null, 'Đây là giải pháp rảnh tay di động âm thanh nổi hoàn hảo nếu bạn muốn thưởng thức nhạc chất lượng cao tại nhà hay khi đi dạo. Thưởng thức âm trầm sâu mạnh mẽ với đai đúc và nệm đeo tai. Tai nghe Di động Âm thanh nổi (Stereo Portable Handsfree) HPM-85 của bạn có đầu cắm 3,5mm tích hợp giúp bạn chuyển sang tai nghe để nghe nhạc trong điện thoại theo cách mong muốn. Tiện ích thỏa mãn đôi tai. ', null, '7');
INSERT INTO `phukien` VALUES ('90', null, 'Tai nghe Bluetooth T9 nhỏ gọn , Tiện lợi khi sử dụng\r\nChuyên dùng để đàm thoại \r\nThời gian nghe liên tục lên đến 4h\r\nThời gian chờ lên đến 2-3 ngày .', 'Bấm giữ cho đến khi cháy sáng đèn đứng yên\r\nSearch Bluetooth điện thoại \r\nKết nối và nhập mã là 4 số 0\r\nKhi kết nối được sẽ xuất hiện hi nh2 tai nghe trên màn hình chính của điện thoại\r\n\r\nCách sạc Pin \r\n-- Khi nghe nhạc thoại đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .\r\n- Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin chai thì tai nghe rất mau hết pin', '7');
INSERT INTO `phukien` VALUES ('91', 'Đen', 'Tai nghe Bluetooth , kiểu dáng nhỏ gọn, chất lượng âm thanh tuyệt thảo , thoải mái nói chuyện khi đi ngoài đường hay trong xe hơi... thư giản nghe nhạc trong khi đi đường và trong xe . Tương thích với tất cả các loại điện thoại di động có hỗ trợ tính năng bluetooth như : Nokia , sam sung  , Sony , Motorola .....', null, '7');
INSERT INTO `phukien` VALUES ('92', 'Nhiều màu', 'Tai nghe Bluetooth , kiểu dáng nhỏ gọn, chất lượng âm thanh tuyệt thảo , thoải mái nói chuyện và thư giản nghe nhạc khi đi ngoài đường hay trong xe hơi. . \r\nNghe nhạc và chuyển bài qua Bluetooth .có jack chuyển bài nằm bên ngoài tai nghe.\r\nTương thích với tất cả các loại điện thoại di động có hỗ trợ tính năng bluetooth như : Nokia , sam sung  , Sony , Motorola .....', '- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì rất mau hết pin .', '7');
INSERT INTO `phukien` VALUES ('93', null, 'Tai nghe Bluetooth , kiểu dáng nhỏ gọn, chất lượng âm thanh tuyệt thảo , thoải mái nói chuyện và thư giản nghe nhạc khi đi ngoài đường hay trong xe hơi , \r\nNghe nhạc và chuyển bài qua Bluetooth .có jack chuyển bài nằm bên ngoài tai nghe.\r\nTương thích với tất cả các loại điện thoại di động có hỗ trợ tính năng bluetooth như : Nokia , sam sung  , Sony , Motorola .....', '- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì rất mau hết pin .', '7');
INSERT INTO `phukien` VALUES ('94', 'Đen, Bạc', 'Tai nghe Bluetooth R9 nhỏ gọn , Tiện lợi khi sử dụng\r\nChuyên dùng để đàm thoại , nghe nhạc, có dây gắn thành nghe 2 tai\r\nThời gian nghe liên tục lên đến 4h\r\nThời gian chờ lên đến 2-3 ngày .', 'Cách mở Bluetooth\r\nBấm giữ cho đến khi cháy sáng đèn đứng yên\r\nSearch Bluetooth điện thoại \r\nKết nối và nhập mã là 4 số 0\r\nKhi kết nối được sẽ xuất hiện hình tai nghe trên màn hình chính của điện thoại\r\n\r\nCách sạc Pin \r\n- Khi nghe nhạc thoại đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .\r\n- Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin chai thì tai nghe rất mau hết pin', '7');
INSERT INTO `phukien` VALUES ('95', 'Đen', 'Nokia BH 101 Bluetooth headset Black \r\nTai nghe Bluetooth BH-101 của Nokia cho phép bạn nghe trong 8 giờ liên tục. Sản phẩm này hỗ trợ cả Bluetooth 2.0 (với tính năng EDR, Handsfree v.1.5, và Headset v.1.1).\r\nGiúp bạn thoải mái đàm thoại khi đi trên xe ,\r\nVừa có thể nghe điện thoại vừa có thể rảnh tay làm công việc khác thật tiện lợi', '- Khi nghe nhạc thoại đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .\r\n- Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin chai thì tai nghe rất mau hết pin', '7');
INSERT INTO `phukien` VALUES ('96', 'Đen, Đỏ', 'Tai nghe Bluetooth không dây BH 104 chính hãng Nokia .\r\n- Cung cấp năng lượng hoàn hảo cho cuộc đàm thoại của bạn , giúp bạn thoải mái đàm thoại với thời gian thoại lên đến 10h .Quản lý cuộc gọi dễ dàng bằng cách nhấn nút ,kiểu dáng phù hợp với mọi đối tượng  , nút điều chỉnh âm lượng trực tiếp trên tai nghe .\r\n- Thời gian thoại lên đến 10h .\r\n- Thời gian chờ lên đến 200h .', 'Tai nghe Bluetooth không dây BH 104 chính hãng Nokia .\r\n- Cung cấp năng lượng hoàn hảo cho cuộc đàm thoại của bạn , giúp bạn thoải mái đàm thoại với thời gian thoại lên đến 10h .Quản lý cuộc gọi dễ dàng bằng cách nhấn nút ,kiểu dáng phù hợp với mọi đối tượng  , nút điều chỉnh âm lượng trực tiếp trên tai nghe .\r\n- Thời gian thoại lên đến 10h .\r\n- Thời gian chờ lên đến 200h .', '7');
INSERT INTO `phukien` VALUES ('97', 'Đen', 'Tai nghe Bluetooth BH - 215 Nokia là tai nghe Bluetooth mono đầu tiên của Nokia có dây , và được bán độc quyền tại thegioididong.com .\r\n\r\nKiểu dáng năng động,  kỹ thuật công nghệ cao\r\n\r\nChế độ rung mạnh, tạo sự trao đổi thuận tiện trong môi trường có tiếng ồn.\r\n\r\nThân Bluetooth có thể gắn vào các kiểu áo đa dạng, kết hợp với sử dụng tai nghe, micro cho cuộc chuyện trò.', 'Mô tả sản phẩm :\r\n\r\nKích thước:    50 x 23 x 16.2 mm\r\nTrọng lượng: 18.7 g\r\nPhím Bật/ Tắt\r\nVolume Lớn / Nhỏ\r\nPhím trượt cho chế độ yên lặng.\r\nNhiệt độ cho phép: -15 °C  đến +55 °C\r\nThời gian hoạt động: Lên đến 10 giờ\r\nThời gian chờ: Lên đến 200 giờ\r\nThời gian sạc: 2 giờ\r\nSạc tương  thích:  Nokia AC-3\r\n\r\nHướng dẫn sử dụng\r\n\r\n- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc 2h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì tai nghe rất mau hết pin .', '7');
INSERT INTO `phukien` VALUES ('98', 'Đen', 'Kiểu dáng nhỏ gọn, thanh Lịch có dây Tai nghe \r\n- Là dạng kẹp áo, tiện lợi\r\n- Giao Diện Bluetooth : 2.1 , 2.0 phiên bản mới .\r\n- Phạm vi kết nối tối đa : 10m\r\n- Trọng lượng : 13,6g\r\nThời Gian đàm thoại lên đến : 5h30P\r\nThời Gian chờ lên đến : 120h', null, '7');
INSERT INTO `phukien` VALUES ('99', null, 'Tai nghe Bluetooth , kiểu dáng nhỏ gọn, chất lượng âm thanh tuyệt thảo , thoải mái nói chuyện và thư giản nghe nhạc khi đi ngoài đường hay trong xe hơi. . \r\n\r\nTương thích với tất cả các loại điện thoại di động có hỗ trợ tính năng bluetooth như : Nokia , sam sung  , Sony , Motorola .....', '- Khi nghe nhạc thoại đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .\r\n- Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin chai thì tai nghe rất mau hết pin', '7');
INSERT INTO `phukien` VALUES ('100', 'Hồng, Xanh , Xám', 'Tai nghe Bluetooth Clip II mini Shine là tai nghe có công nghệ kết nối đa điệm có thể kết nối cùng lúc 2 điện thoại để bạn dễ dàng đàm thoại cùng người thân , \r\nBáo chuông khi nhận cuộc gọi , giúp bạn không bỏ lỡ bất kỳ cuộc gọi từ người thân\r\nThời gian đàm thoại lên đến 6h\r\nThời gian chờ lên đến 120h', 'Hướng dẫn sạc pin Tai nghe Bluetoot\r\n- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì rất mau hết pin \r\nPass \" 0000 \"', '7');
INSERT INTO `phukien` VALUES ('101', null, 'Tai nghe BlueTooth R35 , tai nghe stereo chuyên dùng để nghe nhạc , hỗ trợ A2DP và AVRCP , cho phép bạn chuyển bài trên tai nghe , hỗ trợ nghe nhạc cho tất cả các dòng máy có hỗ trợ tính năng Bluetooth jack gắm 3,5mm , Nokia , samsung , sony , Motorola\r\n\r\n- Thời gian đàm thoại lên đến 6 giờ\r\n- Thời gian chờ lên đến 150 giờ', null, '7');
INSERT INTO `phukien` VALUES ('102', '1 màu', 'Sản phẩm chính hãng, tai nghe không dây, kiểu dáng nhỏ gọn, chất lượng âm thanh tốt, thoải mái nói chuyện khi đi ngoài đường hay trong xe hơi...Với thiết kế đặc biệt hỗ trợ nghe nhạc stereo với chất lượng âm thanh cực tốt. Tương thích với tất cả các loại điện thoại di động có hỗ trợ tính năng bluetooth như: \r\n\r\nVới tai nghe không dây này, bạn hoàn toàn yên tâm khi di chuyển mà vẫn \"vô tư\" nghe/nói chuyện, nghe nhạc MP3......', '- Khi nghe nhạc hay thoại đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì rất mau hết pin .', '7');
INSERT INTO `phukien` VALUES ('103', null, 'Clip Virbrate là dạng tai nghe có dây (mono 1 tai)\r\nKiểu dáng kẹp áo , tiện lợi cho việc sử dụng\r\nCó Rung và chuông khi có cuộc gọi đến\r\nKết nối được 2 điện thoại cùng lúc\r\nThời gian đàm thoại lên đến : 10h\r\nThời gian chờ lên đến :180h', null, '7');
INSERT INTO `phukien` VALUES ('104', null, 'Tai nghe Itech Clip D kiểu dáng sang trọng, hợp thời trang.\r\nMàn hình Oled hiển thị số (hoặc tên người gọi đến), cuộc gọi nhỡ, tình trạng pin.\r\nLưu các số gọi đi, gọi đến, cuộc gọi nhỡ ( tổng cộng 10 số.\r\nThực hiện cuộc gọi trực tiếp từ tai nghe\r\nThời gian đàm thoại : 6.5h\r\nThời gian chờ lên đến : 100h\r\nBluetooth : v 2.0 class 2', '- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì tai nghe rất mau hết pin .', '7');
INSERT INTO `phukien` VALUES ('105', null, 'Tai nghe Bluetooth BH-703 tai nghe công nghệ cao của Nokia cho phép bạn nghe trong 8 giờ liên tục. Sản phẩm này hỗ trợ cả Bluetooth 2.0 (với tính năng EDR, Handsfree v.1.5, và Headset v.1.1).\r\nGiúp bạn thoải mái đàm thoại khi đi trên xe ,\r\nVừa có thể nghe điện thoại vừa có thể rảnh tay làm công việc khác thật tiện lợi .\r\nChỉnh âm lượng chỉ bằng cái vuốt tay trên Bluetooth , công nghệ cảm ứng độc đáo', '- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì tai nghe rất mau hết pin .', '7');
INSERT INTO `phukien` VALUES ('106', null, 'Tai nghe Bluetooth Clip D-Radio là thiết bị hỗ trợ Bluetooth nhận cuộc gọi tự động bằng tai nghe ( stereo 2 tai )\r\n\r\n- Hỗ trợ tính năng phần mềm A2DP giúp bạn nghe nhạc ( stereo ) trên tất cả càc máy điện thoại có hỗ trợ tính năng Bluetooth.\r\n- Hỗ trợ tính năng phần mềm AVRCP giúp bạn chuyển bài hát dễ dàng trên tai nghe Bluetooth \r\n- Hỗ trợ công nghệ DSP , màn hình Oled hiển thị cuộc gọi đến ,\r\n- Đài FM-radio giúp bạn thư giãn giải trí mọi lúc mọi nơi .Chuông báo cuộc gọi đến giúp bạn dễ dàng nhận cuộc gọi từ người thân \r\n\r\nThời gian chơi nhạc lên đến 7h\r\nThời gian đàm thoại lên đến 7h\r\nThời gian chờ lên đến 150h', 'Hướng dẫn sạc pin Tai nghe Bluetooth\r\n- Khi nghe nhạc hay đàm thoại : Có dấu hiệu đứt đoạn thì tai nghe đã sắp hết pin .\r\n- Khi sạc pin cho tai nghe , chỉ cần sạc khoảng 3h là đầy pin .Không nên sạc pin qua đêm vì như vậy sẽ làm pin dễ bị chai\r\n- Khi pin bị chai thì rất mau hết pin \r\nPass \" 8888 \"', '7');
INSERT INTO `phukien` VALUES ('107', null, 'Tai nghe Itech Ivoice Pro kiểu dáng sang trọng, hợp thời trang\r\nLà tai nghe kết nối đa điểm, kết nối 2 máy điện thoại cùng lúc, \r\nChức năng lọc tiếng ồn, giúp cho người nghe, nghe rõ cuộc đàm thoại khi ở chỗ đông người.\r\nThời gian gọi : lên đến 4-5h\r\nThời gian chờ : lên đến 100h\r\nThời gian sạc : 3h', ' Kết nối tai nghe với điện thoại\r\n-    Để tai nghe bluetooth và điện thoại di động trong vòng phạm vi 1m.\r\n-    Bấm giữ nút (khởi động) đa chức năng (MFB) trên 8 giây đến khi đèn chớp xanh và đỏ.\r\n-    Khởi động chức năng bluetooth trong Máy điện thoại di động.\r\n-    Trên máy điện thoại di động chọn mục tìm thiết bị bluetooth, khi đã tìm ra tên thiết bị tai nghe nhập mật mã “0000” sau đó bấm phím “ok” để kết nối.\r\n-    Khi kết nối xong màn hình điện thoại sẽ hiện lên tai nghe bluetooth.\r\n-    Khi lần sau sử dụng chỉ cần khởi động tai nghe và điện thoại (phải khởi động bluetooth) sẽ tự động kết nối.', '7');
INSERT INTO `phukien` VALUES ('108', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- JACK loa 3,5 li sử dụng pin sạc bên trong loa ,\r\n- DÙNG sạc Nokia đầu nhỏ để sạc \r\n- KIỂU dáng đẹp , kích thước nhỏ gọn\r\n- NÚT chỉnh âm lượng trên loa \r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.\r\n\r\n- Khách hàng có thể  sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc \r\n\r\n- Thời gian sạc Loa là từ 3h – 5h\r\n\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa.', '8');
INSERT INTO `phukien` VALUES ('109', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Jack loa 3,5 li sử dụng pin sạc bên trong loa ,\r\n- Dùng sạc Nokia đầu nhỏ để sạc , hoặc dây cáp loa đi kèm theo loa dạng USB mini\r\n- Kiểu dáng đẹp , kích thước nhỏ gọn\r\n- Nút chỉnh âm lượng trên loa \r\n- Phát nhạc trực tiếp từ thẻ nhớ và USB có chứa bài nhạc \r\n- Nút chuyển bài trực tiếp trên loa\r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.\r\n\r\n- Khách hàng có thể  sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc \r\n\r\n- Thời gian sạc Loa là từ 3h – 5h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('110', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Jack loa 3,5 li sử dụng pin sạc bên trong loa ,\r\n- Dùng sạc Nokia đầu nhỏ TGDD để sạc , hoặc dây cáp loa đi kèm theo loa\r\n- Kiểu dáng đẹp , kích thước nhỏ gọn\r\n- Nút chỉnh âm lượng trên loa \r\n- LOA PASS CỰC MẠNH\r\n- CÓ REMOTE ĐIỀU KHIỂN NHẠC TỪ XA\r\n- Phát nhạc trực tiếp từ thẻ nhớ và USB có chứa bài nhạc \r\n- Nút chuyển bài trực tiếp trên loa\r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc\r\nKhuyến mãi : Giảm 40% cho khách hàng có HĐ mua hàng tại thegioididong.com', '- Sử dụng loại sạc Nokia đầu nhỏ TGDD có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.\r\n\r\n- Khách hàng có thể  sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc \r\n\r\n- Thời gian sạc Loa là từ 3h – 5h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('111', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Jack loa 3,5 li sử dụng pin sạc bên trong loa ,\r\n- Dùng sạc Nokia đầu nhỏ TGDD để sạc , hoặc dây cáp loa đi kèm theo loa\r\n- Kiểu dáng đẹp , kích thước nhỏ gọn\r\n- Nút chỉnh âm lượng trên loa \r\n- Màn hình hiển thị âm nhạc nền\r\n- CÓ Remote điều khiển nhạc từ xa\r\n- Phát nhạc trực tiếp từ thẻ nhớ và USB có chứa bài nhạc \r\n- Nút chuyển bài trực tiếp trên loa\r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ TGDD có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.\r\n\r\n- Khách hàng có thể  sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc \r\n\r\n- Thời gian sạc Loa là từ 3h – 5h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('112', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Dùng sạc Nokia đầu nhỏ TGDD để sạc , hoặc dây cáp loa đi kèm theo loa\r\n- LOA PASS CỰC MẠNH\r\n- CÓ REMOTE ĐIỀU KHIỂN NHẠC TỪ XA\r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\n- Bề ngoài Loa được làm bằng chất liệu giả gỗ ép dán bọc lớp giả da simili,. tạo nên cái nhìn chắc chắn cho loa, và âm thanh nghe chuẩn hơn. \r\n- Là dòng có 2 loa phía trước, nên tạo cảm giác âm thanh mạnh bass ấm, mạnh. 1 loa thoát hơi phía sau, công suất mỗi loa 10w,\r\n- Thời gian phát nhạc lên đến 5h\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ TGDD có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.hoặc sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc.\r\n\r\n- Thời gian sạc Loa là 2h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('113', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Dùng sạc Nokia đầu nhỏ TGDD để sạc , hoặc dây cáp loa đi kèm theo loa\r\n- LOA PASS CỰC MẠNH\r\n- CÓ REMOTE ĐIỀU KHIỂN NHẠC TỪ XA\r\n- Là dòng có 3 loa , 1 loa sup ở trên và 2 loa phụ phía trước, Loa sup 15W, mỗi loa phụ có công suất là 7,5 W, là dòng loa công suất lớn nhất trong các dòng loa TD hiện nay thegioididong đang bán \r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\n- Bề ngoài Loa được làm bằng chất liệu giả gỗ ép dán bọc lớp giả da simili,. tạo nên cái nhìn chắc chắn cho loa, và âm thanh nghe chuẩn hơn. \r\n- Thời gian phát nhạc lên đến 5h\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ TGDD có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.hoặc sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc.\r\n- Thời gian sạc Loa là 2h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('114', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Dùng sạc Nokia đầu nhỏ TGDD để sạc , hoặc dây cáp loa đi kèm theo loa\r\n- LOA PASS CỰC MẠNH\r\n- CÓ REMOTE ĐIỀU KHIỂN NHẠC TỪ XA\r\n- Là dòng có 2 loa bên hông, và 2 lỗ thoát hơi, nên âm bass đánh rất mạnh , vì 2 loa bên hông nên âm thanh thoáng , surruond , công suất mỗi loa 10w,\r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\n- Bề ngoài Loa được làm bằng chất liệu giả gỗ ép dán bọc lớp giả da simili,. tạo nên cái nhìn chắc chắn cho loa, và âm thanh nghe chuẩn hơn. \r\n- Thời gian phát nhạc lên đến 5h\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ TGDD có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.hoặc sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc.\r\n\r\n- Thời gian sạc Loa là 2h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('115', 'Đen', 'Loa nghe nhạc dùng cho điện thoại là 1 thiết kế độc đáo , hỗ trợ phát nhạc từ điện thoại , thẻ nhớ và USB với âm thanh cực mạnh như chuẩn . Giúp bạn thưởng thức âm nhạc một cách sành điệu thông qua chiếc \" Dế \" cưng biết hát .\r\n- Dùng sạc Nokia đầu nhỏ TGDD để sạc , hoặc dây cáp loa đi kèm theo loa\r\n- Có màn hình hiện thị tên bài hát , tên ca sĩ, album, và thời gian phát nhạc,.\r\n- Hát được nhạc có đuôi WMA.\r\n- LOA PASS CỰC MẠNH\r\n- CÓ REMOTE ĐIỀU KHIỂN NHẠC TỪ XA\r\nThời gian phát nhạc lên đến 5h\r\n- Có jack nokia , sony ,và 2,5mm tặng kèm .\r\nLoa hỗ trợ cho tất cả các dòng điện thoại di động , có chức năng nghe nhạc', '- Sử dụng loại sạc Nokia đầu nhỏ TGDD có đầu ra ( DC = 5V/350mA hoặc nhỏ hơn )\r\n\r\n- Khách hàng nên sử dụng sạc Loa bằng Dây Cáp Loa đi kèm theo Loa. Sạc Loa thông qua cổng USB của máy tính.hoặc sạc Loa bằng ổ điện 220V thông qua  Adapter Sạc.\r\n\r\n- Thời gian sạc Loa là 2h\r\n- Phát nhạc thông qua thẻ nhớ và USB có chứa bài nhạc sẵn , \r\n- Nút chỉnh qua bài và nút volume chỉ sử dụng được khi phát nhạc bằng thẻ nhớ và USB\r\n- Muốn chỉnh lớn nhỏ thì nhấn giữ luôn vào nút >> , <<\r\n- Muốn chỉnh qua bài thì nhấn 1 cái vào nút >> , <<\r\nChú ý :\r\n+ Không nên sử dụng Loa trong lúc sạc Loa\r\n+ Không nên sạc Loa qua đêm hoặc sạc Loa quá 5h\r\n\r\n“ Để đảm bảo tuổi thọ của Loa – Hãy sạc Loa đúng theo hướng dẫn” \r\n\r\nWarning : Các trường hợp làm sai hướng dẫn, có thể làm hỏng Pin của Loa, thậm chí gây cháy nổ Loa', '8');
INSERT INTO `phukien` VALUES ('116', 'Đen', 'Jack sạc KC điện thoại dùng để kết nối sạc khẩn cấp sạc cho điện thoại , dùng cho các dòng máy Nokia  , Samsung  , Moto , Sony , LG ....', null, '10');
INSERT INTO `phukien` VALUES ('117', 'Đen', 'dùng để kết nối dây sạc đến với điện nguồn . Dùng cho loa nghe nhạc. ', null, '10');
INSERT INTO `phukien` VALUES ('118', 'Trắng', 'Jack loa 2,5mm dùng để chuyển từ jack 2,5 sang 3,5mm ....nghe nhạc từ điện thoại ra loa thông qua jack 2,5mm', null, '10');
INSERT INTO `phukien` VALUES ('119', '1 màu', 'Dây cáp loa , dùng để sạc và sử dụng điện nguồn trực tiếp từ máy tính hoặc kết nối với adapter sạc.....để sạc loa nghe nhạc ', null, '10');

-- ----------------------------
-- Table structure for `sanpham`
-- ----------------------------
DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE `sanpham` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(100) NOT NULL,
  `GiaNhap` double NOT NULL,
  `GiaHienHanh` double NOT NULL,
  `BaoHanh` int(11) NOT NULL,
  `ID_NhaCungCap` int(11) DEFAULT NULL,
  `ID_TinhTrang` int(11) DEFAULT NULL,
  `HienThi` tinyint(1) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sanpham
-- ----------------------------
INSERT INTO `sanpham` VALUES ('1', 'Nokia N900', '12699000', '1269900', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('2', 'ADAPTER T-F MINI', '30000', '30000', '0', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('3', 'ĐẦU ĐỌC THẺ NHỚ 2 IN 1', '65000', '65000', '1', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('4', 'ĐẦU ĐỌC ALL IN 1', '110000', '110000', '1', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('5', 'ĐẦU ĐỌC THẺ APACER 45 IN 1', '180000', '180000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('6', 'THẺ NHỚ MICRO-SD 1GB ( T-F )', '179000', '179000', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('7', 'THẺ NHỚ MICRO - SD 2GB ( T-F )', '249000', '249000', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('8', 'THẺ NHỚ DV RS - MMC 1G', '250000', '250000', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('9', 'MEMORY STICK MICRO 512 MB (M2)', '280000', '280000', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('10', 'ĐẦU ĐỌC THẺ NHỚ APACER ALL IN 1', '300000', '300000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('11', 'THẺ NHỚ MEMORY STICK DUO PRO 2 GB', '350000', '350000', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('12', 'THẺ NHỚ TRANSFLASH 4 G ( T-F )', '395000', '395000', '12', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('13', 'THẺ NHỚ DV RS - MMC 2G', '395000', '395000', '0', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('14', 'BAO DA HỘP TGDD', '150000', '150000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('15', 'BAO DA HỘP TGDD 029S', '150000', '150000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('16', 'BAO DA HỘP TGDD 004S SIZE M', '150000', '150000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('17', 'BAO DA TGDD 196', '150000', '150000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('18', 'BAO DA IPHONE', '150000', '150000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('19', 'TÚI TAY CẦM BẰNG DA', '150000', '150000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('20', 'TÚI TAY CẦM ĐIỆN THOẠI', '150000', '150000', '0', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('21', 'TÚI GOLLA MÁY ẢNH', '155000', '155000', '0', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('22', 'TÚI GOLLA LOẠI ĐIỆN THOẠI', '195000', '195000', '0', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('23', 'VỎ NHỰA IPHONE', '75000', '75000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('24', 'VỎ SILICON', '150000', '150000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('25', 'VỎ PHÁT QUANG IPHONE', '150000', '150000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('26', 'PIN BLD-2 ( 8210 ) TGDD', '135000', '135000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('27', 'PIN BLD-3 (7210) TGDD', '135000', '135000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('28', 'PIN BL-4B TGDD', '145000', '145000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('29', 'PIN MOTO E680 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('30', 'PIN BL-5C TGDD (3650)', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('31', 'PIN BL-4C TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('32', 'PIN BL-5B TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('33', 'PIN V3 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('34', 'PIN V8 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('35', 'PIN L7 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('36', 'PIN BST_38 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('37', 'PIN BST-36 TGDD ( K510 )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('38', 'PIN BST - 40 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('39', 'PIN C170 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('40', 'PIN SAM SUNG D528 ( C260 ) TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('41', 'PIN BST - 30 TGDD ( K700I )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('42', 'PIN BST - 37 TGDD ( K750 )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('43', 'PIN BST-33 TGDD ( W610I )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('44', 'PIN BST-39 TGDD ( W910I )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('45', 'PIN MOTO BT-50 ( W275 )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('46', 'PIN SAM SUNG D900 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('47', 'PIN SAM SUNG J700 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('48', 'PIN MOTO BQ-50 ( W230 )', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('49', 'PIN SAM SUNG B100 TGDD', '195000', '195000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('50', 'PIN BL-5F TGDD', '295000', '295000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('51', 'PIN 6M TGDD', '295000', '295000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('52', 'PIN 6X TGDD', '295000', '295000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('53', 'PIN 5M TGDD', '295000', '295000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('54', 'PIN BP-4L TGDD', '395000', '395000', '6', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('55', 'SẠC ĐA NĂNG CHO MỌI LOẠI PIN', '50000', '50000', '1', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('56', 'SẠC SAMSUNG D800TGDD', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('57', 'SẠC MOTOROLA V3 TGDD', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('58', 'SẠC NOKIA N70', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('59', 'SẠC ZIN SAM SUNG E210', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('60', 'SẠC SONY K800', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('61', 'SẠC USB ĐIỆN THOẠI', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('62', 'SẠC LG KG800', '100000', '100000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('63', 'SẠC KHẨN CẤP', '100000', '100000', '1', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('64', 'SẠC NHANH KHẨN CẤP 1 PIN', '115000', '115000', '1', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('65', 'SẠC IPHONE TGDD', '200000', '200000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('66', 'SẠC XE HƠI DC-6 CH', '200000', '200000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('67', 'SẠC NHANH KHẨN CẤP 2 PIN', '245000', '245000', '1', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('68', 'SẠC DỰ PHÒNG', '350000', '350000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('69', 'DÂY ĐEO ĐIỆN THOẠI', '25000', '25000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('70', 'MIẾNG DÁN TRANG TRÍ ĐIỆN THOẠI', '35000', '35000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('71', 'MIẾNG DÁN MÀN HÌNH IPHONE', '80000', '80000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('72', 'MIẾNG DÁN BẢO VỆ MÀN HÌNH ĐIỆN THOẠI', '80000', '80000', '0', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('73', 'CÁP DỮ LIỆU CỔNG USB SONY ERICSSON K750 TGDD', '90000', '90000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('74', 'CÁP DỮ LIỆU CỔNG USB SAMSUNG D820 TGDD', '90000', '90000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('75', 'CÁP MICRO USB TGDD', '90000', '90000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('76', 'CÁP MINI USB TGDD', '90000', '90000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('77', 'CÁP DKU2 TGDD', '90000', '90000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('78', 'CÁP IPHONE TGDD', '140000', '140000', '3', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('79', 'CỔNG BLUETOOTH', '160000', '160000', '1', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('80', 'TAI NGHE SONY ERICSSON TGDD', '120000', '120000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('81', 'TAI NGHE SAMSUNG D820 TGDD', '120000', '120000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('82', 'TAI NGHE NOKIA 6280 (HS-23) TGDD', '120000', '120000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('83', 'TAI NGHE 6300 TGDD', '120000', '120000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('84', 'TAI NGHE IPOD TGDD', '120000', '120000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('85', 'TAI NGHE SAM SUNG E210 TGDD', '150000', '150000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('86', 'TAI NGHE NOKIA N73 TGDD', '175000', '175000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('87', 'TAI NGHE N95 TGDD', '215000', '215000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('88', 'TAI NGHE HPM-82 TGDD', '215000', '215000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('89', 'TAI NGHE HPM - 85 TGDD', '275000', '275000', '3', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('90', 'TAI NGHE BLUETOOTH T9', '450000', '450000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('91', 'TAI NGHE BLUETOOTH X3D', '545000', '545000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('92', 'TAI NGHE BLUETOOTH A9', '545000', '545000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('93', 'TAI NGHE BLUETOOTH U8 TGDD', '545000', '545000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('94', 'TAI NGHE BLUETOOTH R9', '545000', '545000', '6', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('95', 'TAI NGHE BLUETOOTH NOKIA BH - 101', '990000', '990000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('96', 'TAI NGHE BLUETOOTH BH 104', '990000', '990000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('97', 'TAI NGHE BLUETOOTH BH 215', '1050000', '1050000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('98', 'TAI NGHE BLUETOOTH NOKIA BH 106', '1050000', '1050000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('99', 'TAI NGHE BH 103', '1190000', '1190000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('100', 'TAI NGHE CLIP II MINI SHINE', '1245000', '1245000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('101', 'TAI NGHE BLUETOOTH R35', '1330000', '1330000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('102', 'TAI NGHE BLUETOOTH NOKIA\r\nBH - 501', '1500000', '1500000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('103', 'TAI NGHE CLIP VIRBRATE', '1650000', '1650000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('104', 'TAI NGHE ITECH CLIP D', '1665000', '1665000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('105', 'TAI NGHE BLUETOOTH BH - 703', '2100000', '2100000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('106', 'TAI NGHE CLIP D-RADIO', '2100000', '2100000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('107', 'TAI NGHE ITECH IVOICE PRO', '2100000', '2100000', '12', '2', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('108', 'LOA TD - 01', '350000', '350000', '1', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('109', 'LOA TD - 10', '450000', '450000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('110', 'LOA TD-1B', '460000', '460000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('111', 'LOA TD-18 TGDD', '495000', '495000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('112', 'LOA NGHE NHẠC TD-A12', '550000', '550000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('113', 'LOA NGHE NHẠC TD-A13', '550000', '550000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('114', 'LOA NGHE NHẠC TD-A11', '550000', '550000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('115', 'LOA NGHE NHẠC TD-M1', '650000', '650000', '3', '3', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('116', 'JACK SẠC KC ĐIỆN THOẠI', '20000', '20000', '0', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('117', 'ADAPTER SẠC', '25000', '25000', '0', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('118', 'JACK LOA 2,5MM', '40000', '40000', '0', '1', '1', '1', '0');
INSERT INTO `sanpham` VALUES ('119', 'DÂY CÁP LOA', '40000', '40000', '0', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for `sanpham_nhacungcap`
-- ----------------------------
DROP TABLE IF EXISTS `sanpham_nhacungcap`;
CREATE TABLE `sanpham_nhacungcap` (
  `ID_SanPham` int(11) NOT NULL,
  `ID_NhaCungCap` int(11) NOT NULL,
  PRIMARY KEY (`ID_SanPham`,`ID_NhaCungCap`),
  KEY `ID_NhaCungCap` (`ID_NhaCungCap`),
  CONSTRAINT `sanpham_nhacungcap_ibfk_1` FOREIGN KEY (`ID_SanPham`) REFERENCES `sanpham` (`ID`),
  CONSTRAINT `sanpham_nhacungcap_ibfk_2` FOREIGN KEY (`ID_NhaCungCap`) REFERENCES `nhacungcap` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sanpham_nhacungcap
-- ----------------------------

-- ----------------------------
-- Table structure for `tingiamgiaphukien`
-- ----------------------------
DROP TABLE IF EXISTS `tingiamgiaphukien`;
CREATE TABLE `tingiamgiaphukien` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PhuKien` int(11) DEFAULT NULL,
  `MucGiam` double NOT NULL,
  `ChiTiet` varchar(200) DEFAULT NULL,
  `NgayBatDau` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NgayKetThuc` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `HienThi` tinyint(1) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PhuKien` (`ID_PhuKien`),
  CONSTRAINT `tingiamgiaphukien_ibfk_1` FOREIGN KEY (`ID_PhuKien`) REFERENCES `phukien` (`ID_SanPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tingiamgiaphukien
-- ----------------------------

-- ----------------------------
-- Table structure for `tinhnangnoibat`
-- ----------------------------
DROP TABLE IF EXISTS `tinhnangnoibat`;
CREATE TABLE `tinhnangnoibat` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DienThoai` int(11) DEFAULT NULL,
  `TinhNang` varchar(250) DEFAULT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_DienThoai` (`ID_DienThoai`),
  CONSTRAINT `tinhnangnoibat_ibfk_1` FOREIGN KEY (`ID_DienThoai`) REFERENCES `dienthoai` (`ID_SanPham`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tinhnangnoibat
-- ----------------------------
INSERT INTO `tinhnangnoibat` VALUES ('1', '1', 'Điện thoại truyền thông đa phương tiện', '0');
INSERT INTO `tinhnangnoibat` VALUES ('2', '1', 'Camera 5.0 MP, Camera phụ VGA', '0');
INSERT INTO `tinhnangnoibat` VALUES ('3', '1', 'Kết nối mạng 3.5G với tốc độ lên đến 10 Mbps', '0');
INSERT INTO `tinhnangnoibat` VALUES ('4', '1', 'Hỗ trợ A-GPS, OVI Maps', '0');
INSERT INTO `tinhnangnoibat` VALUES ('5', '1', 'Kết nối Wifi tốc độ cao, Bluetooth, USB', '0');
INSERT INTO `tinhnangnoibat` VALUES ('6', '1', 'Document viewer (Word, Excel, PowerPoint, PDF)', '0');
INSERT INTO `tinhnangnoibat` VALUES ('7', '1', 'Chỉnh sửa hình ảnh', '0');
INSERT INTO `tinhnangnoibat` VALUES ('8', '1', 'Adobe Flash Player 9.4', '0');
INSERT INTO `tinhnangnoibat` VALUES ('10', '1', 'Out Tivi, và jack loa 3.5 mm', '0');

-- ----------------------------
-- Table structure for `tinhtrangsanpham`
-- ----------------------------
DROP TABLE IF EXISTS `tinhtrangsanpham`;
CREATE TABLE `tinhtrangsanpham` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TinhTrang` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tinhtrangsanpham
-- ----------------------------
INSERT INTO `tinhtrangsanpham` VALUES ('1', 'Đang có hàng');
INSERT INTO `tinhtrangsanpham` VALUES ('2', 'Sắp về');
INSERT INTO `tinhtrangsanpham` VALUES ('3', 'Mới về');
INSERT INTO `tinhtrangsanpham` VALUES ('4', 'Hết hàng');

-- ----------------------------
-- Table structure for `tinkhuyenmaidienthoai`
-- ----------------------------
DROP TABLE IF EXISTS `tinkhuyenmaidienthoai`;
CREATE TABLE `tinkhuyenmaidienthoai` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NoiDung` varchar(1000) NOT NULL,
  `NgayBatDau` datetime NOT NULL,
  `NgayKetThuc` datetime NOT NULL,
  `HienThi` tinyint(1) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tinkhuyenmaidienthoai
-- ----------------------------
INSERT INTO `tinkhuyenmaidienthoai` VALUES ('1', 'Giảm giá shock cho Nokia N900', '2010-05-27 19:45:34', '2010-05-30 19:45:40', '1', '0');

-- ----------------------------
-- Table structure for `tintuc`
-- ----------------------------
DROP TABLE IF EXISTS `tintuc`;
CREATE TABLE `tintuc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_LoaiTinTuc` int(11) DEFAULT NULL,
  `NgayDang` datetime NOT NULL,
  `NoiDung` varchar(2000) DEFAULT NULL,
  `HienThi` tinyint(1) NOT NULL,
  `Xoa` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_LoaiTinTuc` (`ID_LoaiTinTuc`),
  CONSTRAINT `tintuc_ibfk_1` FOREIGN KEY (`ID_LoaiTinTuc`) REFERENCES `loaitintuc` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tintuc
-- ----------------------------
INSERT INTO `tintuc` VALUES ('1', '1', '2010-05-27 14:03:35', 'Đây là tin tức 01', '1', '0');
INSERT INTO `tintuc` VALUES ('2', '1', '2010-05-27 14:04:00', 'Đây là tin tức 02', '1', '0');
INSERT INTO `tintuc` VALUES ('3', '1', '2010-05-27 14:04:09', 'Đây là tin tức 03', '1', '0');
INSERT INTO `tintuc` VALUES ('4', '2', '2010-05-27 14:04:21', 'Đây là tin tức 04', '1', '0');
INSERT INTO `tintuc` VALUES ('5', '2', '2010-05-27 14:04:46', 'Đây là tin tức 05', '1', '0');
INSERT INTO `tintuc` VALUES ('6', '2', '2010-05-27 14:04:54', 'Đây là tin tức 06', '1', '0');
INSERT INTO `tintuc` VALUES ('7', '3', '2010-05-27 14:05:04', 'Đây là tin tức 07', '1', '0');
INSERT INTO `tintuc` VALUES ('8', '3', '2010-05-27 14:05:21', 'Đây là tin tức 08', '1', '0');
INSERT INTO `tintuc` VALUES ('9', '3', '2010-05-27 14:05:32', 'Đây là tin tức 09', '1', '0');

-- ----------------------------
-- Table structure for `trangthaidonhang`
-- ----------------------------
DROP TABLE IF EXISTS `trangthaidonhang`;
CREATE TABLE `trangthaidonhang` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TrangThai` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trangthaidonhang
-- ----------------------------
INSERT INTO `trangthaidonhang` VALUES ('1', 'Hoàn tất');
INSERT INTO `trangthaidonhang` VALUES ('2', 'Chưa hoàn tất');

-- ----------------------------
-- Table structure for `trangthaigopy`
-- ----------------------------
DROP TABLE IF EXISTS `trangthaigopy`;
CREATE TABLE `trangthaigopy` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TrangThai` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trangthaigopy
-- ----------------------------
