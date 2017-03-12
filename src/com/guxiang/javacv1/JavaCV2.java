package com.guxiang.javacv1;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;

import com.googlecode.javacv.cpp.opencv_core.CvSize;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class JavaCV2 {

	public static int count = 0;

	public static void main(String[] args) {
		IplImage src = cvLoadImage("C:\\Users\\guxiang\\Desktop\\1.png");

		IplImage blueimg = cvCreateImage(cvGetSize(src), IPL_DEPTH_8U, 3);
		IplImage greenimg = cvCreateImage(cvGetSize(src), IPL_DEPTH_8U, 3);
		IplImage hsvimg = cvCreateImage(cvGetSize(src), IPL_DEPTH_8U, 3);
		IplImage grayimg = cvCreateImage(cvGetSize(src), IPL_DEPTH_8U, 3);

		cvCvtColor(src, blueimg, CV_BGR2YCrCb);
		cvCvtColor(src, greenimg, CV_HLS2BGR);
		cvCvtColor(src, hsvimg, CV_BGR2HSV);
		cvCvtColor(src, grayimg, CV_BGR2XYZ);

		cvShowImage("Original", src);

		showScaleChange(blueimg,"blueing");
		showScaleChange(greenimg,"greenimg");
		showScaleChange(hsvimg,"hsvimg");
		showScaleChange(grayimg,"grayimg");



		cvReleaseImage(src);
		cvReleaseImage(blueimg);
		cvReleaseImage(greenimg);
		cvReleaseImage(hsvimg);
		cvReleaseImage(grayimg);

	}

	private static void showScaleChange(IplImage temp,String name) {

		

		CvSize dst_cvsize = new CvSize(temp.width() / 2, temp.height() / 2);

		IplImage dst = cvCreateImage(dst_cvsize, temp.depth(), temp.nChannels()); // ����Ŀ��ͼ��
		cvResize(temp, dst, 1); // ����Դͼ��Ŀ��ͼ��

		cvNamedWindow(name, CV_WINDOW_AUTOSIZE); // ����������ʾĿ��ͼ��Ĵ���

		cvShowImage(name, dst); // ��ʾĿ��ͼ��
		cvWaitKey();

		cvFlip(dst, null, 0);

		cvNamedWindow(name + "mirror", CV_WINDOW_AUTOSIZE); // ����������ʾĿ��ͼ��Ĵ���

		cvShowImage(name + "mirror", dst); // ��ʾĿ��ͼ��
		cvWaitKey();

	}
}
