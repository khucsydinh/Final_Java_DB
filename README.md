# Final_Java_DB

**YÊU CẦU CHUNG: 
Xây dựng hệ CSDL quản lý thông tin theo một kịch bản cho trước sử dụng MySQL cùng tất cả các kiến thức đã làm quen trong suốt khoá học về Database.
Xây dựng giao diện gồm cả frontend và backend để phát triển các ứng dụng trên nền CSDL đã được xây dựng để tạo nên một hệ thống thông tin hoàn chỉnh theo kịch bản đã cho trước. Backend được xây dựng theo mô hình Web Service trên nền tảng Spring Rest API. Frontend được xây dựng trên nền Web, sử dụng Spring MVC hoặc một frontend framework khác tuỳ chọn.

================================================================
(1) Xây dựng hệ thống quản lý một phòng khám bệnh tư nhân
Yêu cầu về CSDL (Các ràng buộc về số lượng các bản ghi trong CSDL cần phải được thể hiện)
• Thông tin cơ bản về bác sỹ bao gồm CMT, tên, mã số BS, ngày sinh, địa chỉ, bậc nghề, thâm niên, trình độ đào tạo, chuyên môn. 
• Thông tin cơ bản về y tá bao gồm CMT, mã số nhân viên, trình độ, thâm niên, ngày sinh, địa chỉ, số đt
• Thông tin cơ bản về bệnh nhân bao gồm chứng minh thư, mã số bệnh nhân, ngày sinh, địa chỉ, số điện thoại. Mỗi bệnh nhân có thể đến khám và chữa bệnh nhiều lần. 
• Thông tin về mỗi lần khám bao gồm ngày vào viện, ngày ra viện, tên bệnh, mã số lần khám đối với mỗi loại bệnh, tổng số tiền khám/chữa bệnh. 
• Thông tin về các loại thuốc được kê đơn cho mỗi lần khám/chữa bệnh cùng giá tiền của từng loại thuốc cũng cần phải được lưu lại trong CSDL.
• Các bác sỹ khám và chữa bệnh cho các bệnh nhân. Các y tá chăm sóc các bệnh nhân, bao gồm việc tiếp đón, cấp thuốc, tiêm thuốc, và chăm sóc, theo dõi bệnh nhân trong suốt mỗi lần đến khám/chữa bệnh. Mỗi bệnh nhân khi đến khám/chữa bệnh thì cần phải được khám bởi duy nhất một bác sỹ cho mỗi loại bệnh. Một bác sỹ có thể khám và chữa nhiều loại bệnh khác nhau.
• Thực hiện chức năng thêm/xoá/sửa/tìm kiếm các đối tượng trong hệ thống như bác sỹ, y tá, bệnh nhân, thuốc v.v. với các ràng buộc như nêu trong yêu cầu về CSDL.
• Liệt kê danh sách các loại bệnh được các bệnh nhân mắc phải trong tháng 7/2020, các bệnh được sắp xếp theo thứ tự số bệnh nhân đến khám giảm dần. Lưu ý, một bệnh nhân có thể đến khám/chữa một bệnh nào đó nhiều lần trong tháng nhưng cũng chỉ được tính là mắc một lần nếu như các lần khám đó là liên tiếp nhau. Trong CSDL phải thể hiện được là một bệnh nhân có thể mắc lại bệnh nào đó nhiều lần (chữa khỏi, một thời gian sau lại mắc bệnh lại), khi đó sẽ được tính là mắc nhiều lần.
• Tính lương của các Bác sỹ và y tá trong tháng tính đến thời điểm hiện tại, hoặc một tháng cụ thể nào đó với cách tính như sau: lương cơ bản cho BS là 7tr, Y tá là 5tr. Cứ mỗi bệnh nhân đến khám và chữa khỏi một bệnh (kết thúc một chuỗi khám/chữa bệnh nhiều lần liên tiếp cho bệnh đó) bởi một bác sỹ thì bác sỹ đó được cộng thêm 1tr. Mỗi lần một y tá thực hiện hỗ trợ một bệnh nhân trong một lần đến khám/chữa bệnh thì được cộng thêm 200 nghìn đồng.
• Hiển thị thông tin của một bệnh nhân nào đó cùng với tất cả các thông tin khám chữa bệnh của họ từ trước đến nay. Thông tin về tình trạng bệnh của họ tại thời điểm hiện tại (mắc những bệnh gì, khám lần thứ mấy cho mỗi bệnh,…).
• Tính Doanh thu của Phòng khám dựa trên số tiền khám/chữa bệnh của các bệnh nhân và số tiền bán thuốc trên các đơn thuốc.
